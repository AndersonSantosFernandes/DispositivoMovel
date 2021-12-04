package com.meu.trabalhocpm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PessoasDao {

    @Query("select * from pessoas ")
    List<PessoasEntity> listarTodasPessoas();

    @Query("select * from pessoas where matricula = :matriculaPessoas")
    List<PessoasEntity> buscarPessoas(int matriculaPessoas);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserAll(List<PessoasEntity> pessoas);

    @Delete
    void deletePessoas(PessoasEntity ... pessoas);

    @Update
    void updatePessoas(PessoasEntity ... pessoas);
}


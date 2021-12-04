package com.meu.trabalhocpm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// indicar a qual tabela a entidade vai se associar "@Entity(tableName = "nome da tabela")"
@Entity(tableName = "pessoas")
public class PessoasEntity implements Pessoas{

    @PrimaryKey
    private int matricula;
    private String nome;
    private int idade;
    private String Cpf;

    public PessoasEntity(){
        super();
    }

    public PessoasEntity(int matricula, String nome, int idade, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        Cpf = cpf;
    }

    public PessoasEntity(Pessoas pessoas){
        this.matricula = pessoas.getMatricula();
        this.nome = pessoas.getNome();
        this.idade = pessoas.getIdade();
        this.Cpf = pessoas.getCpf();


    }

    @Override
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    @Override
    public String toString() {
        return
                "Matrícula= " + matricula + '\n' +
                "Nome= " + nome + '\n' +
                "Idade= " + idade + '\n' +
                "CPF= " + Cpf + '\n';
    }
}

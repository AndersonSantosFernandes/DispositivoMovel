package com.meu.trabalhocpm;

import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;

public interface Mapa1 {
    void onMapReady(GoogleMap googleMap);

    void onLocationChanged(@NonNull Location location);

    //*************************************************************************
    void onStatusChanged(String provider, int status, Bundle extras);

    void onProviderEnabled(@NonNull String provider);

    void onProviderDisabled(@NonNull String provider);
}

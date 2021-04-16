package com.example.canacomercio.common;

import android.app.Application;
import android.content.Context;

public class MiApp extends Application {

    private static MiApp instancia;

    public static MiApp getInstance(){
        return instancia;
    }

    public static Context getContext(){
        return instancia;
    }

    @Override
    public void onCreate() {
        instancia = this;
        super.onCreate();
    }
}

package com.example.canacomercio.common;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String APP_SETTINGS_FILE = "APP_SETTINGS";

    private SharedPreferencesManager() {}

    private static SharedPreferences getSharedPreferences() {
        return MyApp.getContext().getSharedPreferences(APP_SETTINGS_FILE, Context.MODE_PRIVATE);
    }

    public static void setSomeStringValue(String dataLabel, String dataValue) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(dataLabel, dataValue);
        editor.commit();
    }

    public static void setSomeIntegerValue(String dataLabel, int dataValue) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(dataLabel, dataValue);
        editor.commit();
    }

    public static String getSomeStringValue(String dataLabel) {
        return getSharedPreferences().getString(dataLabel, null);
    }

    public static Integer getSomeIntegerValue(String dataLabel) {
        return getSharedPreferences().getInt(dataLabel, -1 );
    }

}

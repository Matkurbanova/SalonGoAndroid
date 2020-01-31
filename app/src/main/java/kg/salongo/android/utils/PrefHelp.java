package kg.salongo.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefHelp {
    private static PrefHelp instance;

    private Context context;
    private SharedPreferences preferences;

    private PrefHelp() {
    }

    public static PrefHelp edit() {
        if (instance == null)
            instance = new PrefHelp();
        return instance;
    }

    public void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public Boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    public static void init(Context context) {
        edit().setContext(context);
    }


    private PrefHelp setContext(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("SalonGoPrefs", Context.MODE_PRIVATE);
        return this;
    }
}

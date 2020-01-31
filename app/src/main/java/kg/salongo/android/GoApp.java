package kg.salongo.android;

import android.app.Application;

import kg.salongo.android.utils.PrefHelp;

public class GoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PrefHelp.init(this);
    }
}

package me.mattak.example.outlined_text;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * MainApplication
 * Created by mattak on 2015/11/24.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Raleway-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

    }
}
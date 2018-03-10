package com.landtanin.arpersonexplorer;

import android.app.Application;

import com.landtanin.arpersonexplorer.manager.Contextor;

/**
 * Created by Tanin on 10/03/2018.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}

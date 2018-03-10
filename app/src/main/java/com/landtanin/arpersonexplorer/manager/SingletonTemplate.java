package com.landtanin.arpersonexplorer.manager;

import android.content.Context;

/**
 * Created by landtanin on 1/21/2017 AD.
 */

public class SingletonTemplate {

    private static SingletonTemplate instance;

    public static  SingletonTemplate getInstance() {
        if (instance == null)
            instance = new SingletonTemplate();
        return instance;
    }

    private Context mContext;

    private SingletonTemplate() {
        mContext = Contextor.getInstance().getContext();
    }

}

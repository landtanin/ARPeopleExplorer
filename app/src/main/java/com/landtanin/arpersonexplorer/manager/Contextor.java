package com.landtanin.arpersonexplorer.manager;

import android.content.Context;

/**
 * Created by User on 6/5/2560.
 */

/**
 * init getInstance to call the instance the context of application in other classes
 */
public class Contextor {

    private static Contextor instance;

    // init getInstance to call the instance the context of application in other classes
    public static Contextor getInstance() {
        if (instance == null) {
            instance = new Contextor();
        }

        return instance;
    }

    private Context mContext;

    private Contextor() {

    }

    public void init(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

}

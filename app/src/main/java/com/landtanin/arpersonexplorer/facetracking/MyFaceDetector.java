package com.landtanin.arpersonexplorer.facetracking;

import android.util.SparseArray;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;

/**
 * Created by Tanin on 10/03/2018.
 */

public class MyFaceDetector extends Detector<Face> {

    private Detector<Face> mDelegate;
    public Frame frame;

    MyFaceDetector(Detector<Face> delegate) {
        mDelegate = delegate;
    }


    public SparseArray<Face> detect(Frame frame) {

        this.frame = frame;
        return mDelegate.detect(frame);
    }

    public boolean isOperational() {
        return mDelegate.isOperational();
    }

    public boolean setFocus(int id) {
        return mDelegate.setFocus(id);
    }
}

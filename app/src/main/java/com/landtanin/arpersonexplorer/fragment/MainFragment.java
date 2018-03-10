package com.landtanin.arpersonexplorer.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landtanin.arpersonexplorer.R;
import com.landtanin.arpersonexplorer.databinding.FragmentMainBinding;
import com.landtanin.arpersonexplorer.facetracking.FaceActivity;

import java.io.File;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;


/**
 * Created by landtanin on 5/1/2017 AD.
 */
public class MainFragment extends Fragment {

    FragmentMainBinding b;
    MainFragment mainFragment = this;

    // constructor of Fragment must be Default constructor (has no arguments)
    public MainFragment() {
        super();
    }


    /**
     * <p>
     * Provide a pre-call instance of this fragment
     * <p>
     * @return an instance of this fragment
     */
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        In case of using binding tool
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View rootView = b.getRoot();
//        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        // Note: State of variable initialized here could not be saved
        //       in onSavedInstanceState

        b.pickImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = "";
                EasyImage.openChooserWithGallery(mainFragment, "Camera or Gallery", 0);

            }
        });

        b.liveCamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objIntent = new Intent(getContext(), FaceActivity.class);
//                objIntent.putExtra("key", data);
                startActivity(objIntent);

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, getActivity(), new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {

                if(imageFile.exists()){

                    Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());

                    b.faceImgView.setImageBitmap(myBitmap);

                }

            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance (Fragment level's variables) State here
    }

    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance (Fragment level's variables) State here
    }

}

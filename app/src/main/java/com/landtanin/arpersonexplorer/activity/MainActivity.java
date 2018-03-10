package com.landtanin.arpersonexplorer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.landtanin.arpersonexplorer.R;
import com.landtanin.arpersonexplorer.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance())
                    .commit();

        }

    }
}

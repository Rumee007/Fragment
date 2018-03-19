package com.example.mobileapp.fragmentpb4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentOne.MessageListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private Bundle bundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "Activity: onCreate called");
        // Fragment initialise
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentOne fragmentOne = FragmentOne.getInstance("Hello Fragment One");

        //Pass value with bundle
        //bundle = new Bundle();
        //bundle.putString("Yes", "Yes");
        //fragmentOne.setArguments(bundle);

        ft.add(R.id.fragmentContainer,fragmentOne);
        // back button : stack request
        ft.addToBackStack(null);
        ft.commit();
    }

    // OnClick Button
    public void changeFragment(View view) {
        Fragment fragment = null;
        switch (view.getId()){
            case R.id.f1:
                fragment = FragmentOne.getInstance("Hello Fragment One");
                break;
            case R.id.f2:
                fragment = FragmentTwo.getInstance("Hello Fragment Two");
//                fragment = new FragmentTwo();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "Activity: onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "Activity: onResume called");
    }


    @Override
    public void getMessage(String msg) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentTwo fragmentTwo = FragmentTwo.getInstance(msg);
        ft.replace(R.id.fragmentContainer,fragmentTwo);
        ft.addToBackStack(null);
        ft.commit();
    }
}
package com.example.rogerpaviani.meuapp83fragments;

import android.bluetooth.BluetoothProfile;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RedFragment.OnRedFragmentInteractionListener, GreenFragment.OnFragmentInteractionListener, BlueFragment.OnBlueFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onFragmentInteractionBlue(null);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back pressed...", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    @Override
    public void onFragmentInteractionBlue(Uri uri) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, RedFragment.newInstance(null, null));
        fragmentTransaction.addToBackStack("red");
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteractionRed(Uri uri) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, GreenFragment.newInstance(null, null));
        fragmentTransaction.addToBackStack("green");
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, BlueFragment.newInstance(null, null));
        fragmentTransaction.addToBackStack("blue");
        fragmentTransaction.commit();
    }
}

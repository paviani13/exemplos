package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

/**
 * Created by robson on 10/01/17.
 */

public class NumbersClickListener implements View.OnClickListener {

    @Override
    public void onClick(View view){
        Toast.makeText(view.getContext(),
                "Open the list numbers", Toast.LENGTH_SHORT).show();
    }
}

package com.android.absensiqrcode.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.bottomnavigasi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatkulFragment extends Fragment {


    public MatkulFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matkul, container, false);
    }

}

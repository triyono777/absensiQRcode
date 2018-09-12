package com.android.absensiqrcode.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.absensiqrcode.ScanQRCodeActivity;
import com.android.bottomnavigasi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button btnScanHome;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnScanHome = (Button) view.findViewById(R.id.btn_absen_home);
        btnScanHome.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.buttonScan:
                Intent intent = new Intent(getActivity(), ScanQRCodeActivity.class);
                getActivity().startActivity(intent);
//                break;
//        }
    }
}

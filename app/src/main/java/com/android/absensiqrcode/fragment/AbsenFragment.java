package com.android.absensiqrcode.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.bottomnavigasi.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class AbsenFragment extends Fragment implements View.OnClickListener {

    private Button buttonScan;
    private TextView textViewDosen, textViewTanggal, textViewMatkul, textViewRuang;
    private IntentIntegrator intentIntegrator;

    public AbsenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_absen, container, false);
        buttonScan = (Button) view.findViewById(R.id.buttonScan);
        textViewDosen = (TextView) view.findViewById(R.id.textViewDosen);
        textViewMatkul = (TextView) view.findViewById(R.id.textViewMatkul);
        textViewRuang = (TextView) view.findViewById(R.id.textViewRuang);
        textViewTanggal = (TextView) view.findViewById(R.id.textViewTgl);


        buttonScan.setOnClickListener(this);
        return view;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
//                Toast.makeText(this, "Hasil tidak ditemukan", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),"Hasil tidak ditemukan", Toast.LENGTH_SHORT).show();
            } else {
                // jika qrcode berisi data
                try {
                    // converting the data json
                    JSONObject object = new JSONObject(result.getContents());
                    // atur nilai ke textviews
                    textViewTanggal.setText(object.getString("Tanggal"));
                    textViewDosen.setText(object.getString("Dosen"));
                    textViewMatkul.setText(object.getString("Matkul"));
                    textViewRuang.setText(object.getString("Ruang"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    // jika format encoded tidak sesuai maka hasil
                    // ditampilkan ke toast
//                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show()
                    Toast.makeText(getActivity(), result.getContents(), Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonScan:
                intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator.initiateScan();
                break;
        }


    }
}

package com.ihfazh.dicodinglatihantesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MainViewModel mainViewModel;

    private EditText tinggi, lebar, panjang;
    private TextView result;
    private Button calculateVolume, calculateSurfaceArea, calculateCircumference, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(new CuboidModel());

        tinggi = findViewById(R.id.et_tinggi);
        lebar = findViewById(R.id.et_lebar);
        panjang = findViewById(R.id.et_panjang);

        result = findViewById(R.id.tv_hasil);

        calculateVolume = findViewById(R.id.btn_htg_volume);
        calculateSurfaceArea = findViewById(R.id.btn_luas_permukaan);
        calculateCircumference = findViewById(R.id.btn_htg_keliling);
        save = findViewById(R.id.btn_save);

        calculateVolume.setOnClickListener(this);
        save.setOnClickListener(this);
        calculateSurfaceArea.setOnClickListener(this);
        calculateCircumference.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String length = panjang.getText().toString();
        String height = tinggi.getText().toString();
        String width = lebar.getText().toString();

        if (TextUtils.isEmpty(length)){
            panjang.setError("Field ini tidak boleh kosong");
        } else if (TextUtils.isEmpty(height)){
            tinggi.setError("Field ini tidak boleh kosong");
        } else if (TextUtils.isEmpty(width)){
            lebar.setError("Field ini tidak boleh kosong.");
        } else {
            double l, h, w;
            l = Double.parseDouble(length);
            h = Double.parseDouble(height);
            w = Double.parseDouble(width);

            switch (v.getId()){
                case R.id.btn_save:
                    mainViewModel.save(l, h, w);
                    visible();
                    break;
                case R.id.btn_htg_keliling:
                    result.setText(String.valueOf(mainViewModel.getCircumference()));
                    gone();
                    break;
                case R.id.btn_htg_volume:
                    result.setText(String.valueOf(mainViewModel.getVolume()));
                    gone();
                    break;
                case R.id.btn_luas_permukaan:
                    result.setText(String.valueOf(mainViewModel.getSurfaceArea()));
                    gone();
                    break;
            }
        }

    }

    private void gone() {
        save.setVisibility(View.VISIBLE);
        calculateCircumference.setVisibility(View.GONE);
        calculateSurfaceArea.setVisibility(View.GONE);
        calculateVolume.setVisibility(View.GONE);

    }

    private void visible() {
        save.setVisibility(View.GONE);
        calculateCircumference.setVisibility(View.VISIBLE);
        calculateSurfaceArea.setVisibility(View.VISIBLE);
        calculateVolume.setVisibility(View.VISIBLE);
    }
}
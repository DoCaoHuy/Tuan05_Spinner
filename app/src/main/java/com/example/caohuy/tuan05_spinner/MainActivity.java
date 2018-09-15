package com.example.caohuy.tuan05_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtMa, txtTen;
    private Button btnThem;
    private RadioGroup radGr;
    private ArrayList<NhanVien> arrNhanVien=null;
    private MyArrayAdapter adapter=null;
    private Spinner spNV=null;

    private ArrayList<String> arrText;
    private ArrayAdapter adapterText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMa=(EditText)findViewById(R.id.txtID);
        txtTen=(EditText)findViewById(R.id.txtName);
        btnThem=(Button)findViewById(R.id.btnThem);
        radGr=(RadioGroup)findViewById(R.id.radGroup);
        spNV=(Spinner)findViewById(R.id.spnDS);

        arrNhanVien=new ArrayList<NhanVien>();
        adapter=new MyArrayAdapter(this, R.layout.layout_custom, arrNhanVien);
        spNV.setAdapter(adapter);
        btnThem.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        boolean gt=false;
        if(radGr.getCheckedRadioButtonId()==R.id.radNu)
            gt=true;
        arrNhanVien.add(new NhanVien(txtMa.getText().toString(), txtTen.getText().toString(), gt));

        adapter.notifyDataSetChanged();

    }
}

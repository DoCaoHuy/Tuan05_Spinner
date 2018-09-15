package com.example.caohuy.tuan05_spinner;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Student on 9/11/2018.
 */

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context=null;
    ArrayList<NhanVien> myArray=null;
    int layoutID;


    public MyArrayAdapter(Activity context, int textViewResourceID, ArrayList<NhanVien> objects) {
        super(context, textViewResourceID, objects);
        this.context=context;
        this.layoutID=textViewResourceID;
        this.myArray=objects;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position,View convertView, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        convertView=inflater.inflate(layoutID, null);
        if(myArray.size()>0 && position>=0){
            final TextView txtDisplay=(TextView)convertView.findViewById(R.id.lbl_item);
            final NhanVien nv=myArray.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imgitem=(ImageView)convertView.findViewById(R.id.img_item);
            if(nv.isGender()){
                imgitem.setImageResource(R.drawable.girl);
            }else {
                imgitem.setImageResource(R.drawable.boy);
            }
        }

        return convertView;

    }
}

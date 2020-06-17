package com.example.photosapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;

public class Activity2 extends AppCompatActivity {

    private ListView lv1;
    private ImageView iv1;
    private String[] archivos;
    private ArrayAdapter<String> adaptador1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        File dir=getExternalFilesDir(null);
        archivos=dir.list();
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,archivos);
        lv1=(ListView)findViewById(R.id.ListV);
        lv1.setAdapter(adaptador1);

        iv1=(ImageView)findViewById(R.id.ImaV);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Bitmap bitmap1 = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+archivos[arg2]);
                iv1.setImageBitmap(bitmap1);
            }});
    }
}

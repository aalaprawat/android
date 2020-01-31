package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Date;

import static com.example.recyclerview.R.id.recycler;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    RecyclerView rv ;
    Button bt;
    Bitmap image;
    EditText ed1,ed2;
    RecyclerView.LayoutManager lm;
    ArrayList <student> studentlist;
    MyAdapter1 myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentlist = new ArrayList<>();
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.name);
        bt=findViewById(R.id.adda);
        rv=findViewById(R.id.recycler);
        myadapter = new MyAdapter1(this,studentlist);
        lm=new GridLayoutManager(this,2);
        rv.setLayoutManager(lm);
        rv.setAdapter(myadapter);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString();
                String date = new Date().toString();
                TakePicture();
                student s = new student(name,date,image);
                studentlist.add(s);
                myadapter.notifyDataSetChanged();
            }
        });
    }

    private void TakePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
        protected void onActivityResult(int requestCode , int resultCode, Intent data) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap image = (Bitmap) extras.get("data");
            }
        }

}

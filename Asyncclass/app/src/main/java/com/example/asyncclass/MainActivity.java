package com.example.asyncclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> a;
    ArrayList<String> cities = new ArrayList<>();
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.pro);
        new newtask().execute();
        ListView lv = findViewById(R.id.lv);

        a= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,cities);
        a.notifyDataSetChanged();
        lv.setAdapter(a);
    }

    class newtask extends AsyncTask<Void,Integer,String>{

        @Override
        protected String doInBackground(Void... voids) {
            for (int i=0;i<100;i++)
            {
                try {
                    sleep(100);
                    publishProgress(i);
                    cities.add("aalap"+i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            pb.setMax(100);
            pb.setProgress(0);
            pb.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb.setProgress(values[0]);
            super.onProgressUpdate(values);
            a.notifyDataSetChanged();
        }

        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this,"Downloaded",Toast.LENGTH_LONG).show();
        }
    }
}

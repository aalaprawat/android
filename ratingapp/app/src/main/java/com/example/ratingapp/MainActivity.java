package com.example.ratingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b;
RatingBar r;
TextView ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=findViewById(R.id.rating);
        b=findViewById(R.id.submit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = "rating:"+r.getRating();
                String stars = "stars :"+r.getNumStars();
                ed.setText(rating+stars);
                Toast.makeText(MainActivity.this,rating+"\n"+stars,Toast.LENGTH_LONG).show();
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setCancelable(false);
                ab.setMessage("This is necessary");
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Thankyou for the feed back",Toast.LENGTH_LONG).show();
                    }
                });
                View v1= getLayoutInflater().inflate(R.layout.rating,null,false);

                ab.setView(v1);
                ed=findViewById(R.id.fetch);
                AlertDialog ab2 = ab.create();
                ab.show();
            }});
    }
}

package com.example.customdynamiclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.customdynamiclistview.R.drawable.ic_launcher_foreground;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    ArrayList<person> person1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);
        person1 = new <person> ArrayList();

        person aalap = new person("aalap Rawat", ic_launcher_foreground,R.drawable.ic_touch_app_black_24dp);
        person1.add(aalap);
        person1.add(aalap);
        person1.add(aalap);
        person1.add(aalap);
        person1.add(aalap);
        person1.add(aalap);

        PersonDataAdapter pad = new PersonDataAdapter(this,person1);
        lv.setAdapter(pad);
    }
}

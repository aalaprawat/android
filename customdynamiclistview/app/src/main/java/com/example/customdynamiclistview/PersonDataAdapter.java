package com.example.customdynamiclistview;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PersonDataAdapter extends BaseAdapter{

    ArrayList <person> person;
    Context ctx;

    public PersonDataAdapter(Context ctx, ArrayList <person> aperson1){
        this.ctx=ctx;
        this.person=aperson1;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        person p = (person) getItem(position);
        Activity act = (Activity) ctx;

        View v1 = act.getLayoutInflater().inflate(R.layout.personlayout,null);

        ImageView iv1 = v1.findViewById(R.id.iv1);
        ImageView iv2 = v1.findViewById(R.id.iv2);
        TextView tv = v1.findViewById(R.id.tv);
        tv.setText(p.getName());
        iv1.setImageResource(p.getPhoto());
        iv2.setImageResource(p.getCross());


        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.remove(person.get(position));
                notifyDataSetChanged();
            }
        });
        return v1;
    }


}

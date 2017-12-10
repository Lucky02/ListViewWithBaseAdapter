package com.example.blaise.listviewwithbaseadapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.listView);
        list.setAdapter(new VivzAdapter(this));
    }
}

class SingleRow {
    String title;
    String description;
    int image;

    SingleRow (String title, String description, int image){

        this.title = title;
        this.description = description;
        this.image = image;
    }
}
class VivzAdapter extends BaseAdapter {

    ArrayList<SingleRow> list;
    Context context;

    VivzAdapter (Context c) {
        context = c;
        list = new ArrayList<SingleRow>();

        Resources res = c.getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] descriptions = res.getStringArray((R.array.description));
        int[] images = {R.drawable._picture1, R.drawable._picture2, R.drawable._picture3, R.drawable._picture4, R.drawable._picture5, R.drawable._picture6, R.drawable._picture7, R.drawable._picture8,R.drawable._picture9, R.drawable._picture10 };

        for(int i = 0; i<10; i++){

            list.add(new SingleRow(titles[i], descriptions[i], images[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //View row = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_row,viewGroup, false);
            TextView title = (TextView) view.findViewById(R.id.textView);
            TextView description = (TextView) view.findViewById(R.id.textView2);
            ImageView image = (ImageView) view.findViewById(R.id.imageView);

            SingleRow temp = list.get(i);

            title.setText(temp.title);
            description.setText(temp.description);
            image.setImageResource(temp.image);
        }
        return view;
    }
}
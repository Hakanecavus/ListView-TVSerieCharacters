package com.example.tvcharacters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.listView);

        final ArrayList<String> characters=new ArrayList<>();
        characters.add("Jon Snow");
        characters.add("Khaleesi");
        characters.add("BoJack Horseman");
        characters.add("Rick");

        final ArrayList<String> tvSerie=new ArrayList<>();
        tvSerie.add("Game Of Thrones");
        tvSerie.add("Game Of Thrones");
        tvSerie.add("BoJack Horseman");
        tvSerie.add("Rick and Morty");



        Bitmap jonSnow= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.jonsnow);
        Bitmap khaleesi=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.khaleesi);
        Bitmap rick=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.rick);
        Bitmap bojack=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bojack);

        final ArrayList<Bitmap> imageArray=new ArrayList<>();
        imageArray.add(jonSnow);
        imageArray.add(khaleesi);
        imageArray.add(bojack);
        imageArray.add(rick);

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,characters);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),showPage.class);
                intent.putExtra("name",tvSerie.get(i));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(imageArray.get(i));
                startActivity(intent);
            }
        });



    }
}

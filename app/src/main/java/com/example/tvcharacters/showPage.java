package com.example.tvcharacters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class showPage extends AppCompatActivity {
    ImageView image;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_page);
        image=findViewById(R.id.imageView);
        text=findViewById(R.id.textView);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        text.setText("TV Serie: "+name);
        Singleton singleton=Singleton.getInstance();
        image.setImageBitmap(singleton.getChosenImage());
    }
}

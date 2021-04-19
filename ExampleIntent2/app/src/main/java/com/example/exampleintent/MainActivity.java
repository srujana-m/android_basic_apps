package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     EditText name,number,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        link=findViewById(R.id.link);

    }

    public void send(View view) {

        String n=name.getText().toString();
        Intent i= new Intent(this,SecondActivity.class);
        i.putExtra("name",n);
        startActivity(i);
    }

    public void search(View view) {
        String l=link.getText().toString();
        Uri uri=Uri.parse("https://"+l);
        Intent i=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);



    }

    public void call(View view) {

        String num=number.getText().toString();
        Uri uri=Uri.parse("tel:"+num);
        Intent i=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);

    }
}
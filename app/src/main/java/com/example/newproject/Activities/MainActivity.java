package com.example.newproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.newproject.R;

public class MainActivity extends AppCompatActivity {

    TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String value = "";
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            value = bundle.getString("response");
            response = findViewById(R.id.responseLogin);
            response.setText(value);
        }


    }
}
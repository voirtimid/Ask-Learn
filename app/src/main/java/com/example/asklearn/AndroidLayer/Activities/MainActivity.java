package com.example.asklearn.AndroidLayer.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.asklearn.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickMeOnClick(View view) {
        Toast.makeText(this, "Hello from the other side", Toast.LENGTH_LONG).show();
    }
}

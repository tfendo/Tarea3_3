package com.hugoguillin.hellocompat;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.hello_textview);
        if (savedInstanceState != null){
            text.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the current text color
        outState.putInt("color", text.getCurrentTextColor());
    }

    public void changeColor(View view) {
        Random random = new Random();
        String color = mColorArray[random.nextInt(20)];
        int recurso = getResources().getIdentifier(color, "color",
                getApplicationContext().getPackageName());
        int colorRecurso = ContextCompat.getColor(this,recurso);
        text.setTextColor(colorRecurso);
    }
}

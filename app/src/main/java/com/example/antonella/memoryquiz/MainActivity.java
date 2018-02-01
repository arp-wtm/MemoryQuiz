package com.example.antonella.memoryquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//this is the first screen activity

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

 /* when the button of start "click here when ready" is clicked
  * this method is called to send an intent
  * that opens the second screen
  */

    public void setSecondScreen(View view) {
        startActivity(new Intent(MainActivity.this, QuestionActivity.class));
    }


}

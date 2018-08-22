package com.durga.balaji66.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityOne extends AppCompatActivity implements View.OnClickListener {

    private Button mImplicitIntent, mExplicitIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeListeners();
    }

    public void initializeViews() {
        mExplicitIntent = (Button)findViewById(R.id.buttonExplicitIntent);
        mImplicitIntent = (Button)findViewById(R.id.buttonImplicitIntent);
    }
    public void initializeListeners() {
        mExplicitIntent.setOnClickListener(this);
        mImplicitIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonExplicitIntent:
                Intent intentActivityTwo = new Intent(ActivityOne.this, ActivityTwo.class);
                startActivity(intentActivityTwo);
                break;

            case R.id.buttonImplicitIntent:
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com"));
                startActivity(intent);
                break;
        }
    }
}

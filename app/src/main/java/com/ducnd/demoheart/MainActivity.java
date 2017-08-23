package com.ducnd.demoheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private CustomILY customILY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customILY = (CustomILY)findViewById(R.id.heart);
    }

    @Override
    protected void onResume() {
        super.onResume();
        customILY.onResume();
    }

    @Override
    protected void onPause() {
        customILY.onPause();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        customILY.onPause();
        super.onBackPressed();
    }
}

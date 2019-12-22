package com.besolutions.drnour.Scenarios.ScenarioHome.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.besolutions.drnour.R;
import com.ldoublem.loadingviewlib.view.LVCircularZoom;

public class Splash extends AppCompatActivity {

    LVCircularZoom mLVCircularZoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        mLVCircularZoom=(LVCircularZoom) findViewById(R.id.lv_circularZoom);
        mLVCircularZoom.startAnim();


    }
}

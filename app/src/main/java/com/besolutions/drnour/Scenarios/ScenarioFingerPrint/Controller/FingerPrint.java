package com.besolutions.drnour.Scenarios.ScenarioFingerPrint.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;

import co.infinum.goldfinger.Error;
import co.infinum.goldfinger.Goldfinger;

public class FingerPrint extends AppCompatActivity {
    Goldfinger goldfinger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);

        goldfinger= new Goldfinger.Builder(FingerPrint.this).build();

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (goldfinger.hasFingerprintHardware() && goldfinger.hasEnrolledFingerprint()) {

            authenticateUserFingerprint();

        }else
        {


        }
    }

    private void authenticateUserFingerprint() {
        final ImageView finger=(ImageView)findViewById(R.id.finger);
        goldfinger.authenticate(new Goldfinger.Callback() {
            @Override
            public void onError(Error error) {
                Toast.makeText(FingerPrint.this, "not match", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(String value) {
                //login.setEnabled(true);
                Toast.makeText(FingerPrint.this, "successfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(FingerPrint.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        goldfinger.cancel();
    }
}

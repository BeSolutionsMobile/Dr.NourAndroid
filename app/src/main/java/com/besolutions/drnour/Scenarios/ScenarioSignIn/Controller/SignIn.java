package com.besolutions.drnour.Scenarios.ScenarioSignIn.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioFingerPrint.Controller.FingerPrint;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;
import com.besolutions.drnour.Scenarios.ScenarioSignUp.Controller.SignUp;
import com.besolutions.drnour.local_data.saved_data;
import com.besolutions.drnour.local_data.send_data;

public class SignIn extends AppCompatActivity {


    TextView txtregister;
    Button btnsignin;
    CheckBox fingerprint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtregister = findViewById(R.id.txtRegister);
        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignIn.this, SignUp.class));

            }
        });

        btnsignin = findViewById(R.id.btnSignIn);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignIn.this, MainActivity.class));
            }
        });

        fingerprint = findViewById(R.id.fingerprint);
        fingerprint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b==true)
                {
                    send_data.SAVE_FINGER_PRINT(SignIn.this,true);
                }
                else {
                    send_data.SAVE_FINGER_PRINT(SignIn.this,false);
                }

            }
        });
       // ifLogin();

    }

    private void ifLogin() {
        saved_data savedId = new saved_data();
        if(savedId.get_finger_status(this)==true)
        {
            startActivity(new Intent(SignIn.this, FingerPrint.class));
            finish();
        }else {
            startActivity(new Intent(SignIn.this, MainActivity.class));
            finish();
        }

    }
}

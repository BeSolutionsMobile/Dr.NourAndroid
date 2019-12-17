package com.besolutions.drnour.Scenarios.ScenarioReferral.Controller;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.besolutions.drnour.R;

public class Referral_Popup extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.referral_popup,container,false);


        //MAKING THE FRAGMENT DIALOG TO SHOW IN TOP IN THE ACTIVITY

        /*
        getDialog().getWindow().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.y = 50;
        getDialog().getWindow().setAttributes(params);
         */

        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return view;
    }
}

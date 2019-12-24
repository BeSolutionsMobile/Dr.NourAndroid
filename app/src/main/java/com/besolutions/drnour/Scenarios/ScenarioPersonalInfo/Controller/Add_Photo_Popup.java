package com.besolutions.drnour.Scenarios.ScenarioPersonalInfo.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;

public class Add_Photo_Popup extends DialogFragment {
    static public ImageView imageView;

    public static ImageView image_uplaod;
    Button btndsave;
    static  String image_url="0";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.add_photo_popup,container,false);
        int width = (int)(getContext().getResources().getDisplayMetrics().widthPixels*.90);
        int height = android.view.WindowManager.LayoutParams.WRAP_CONTENT;

        getDialog().getWindow().setLayout(width, height);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        btndsave = view.findViewById(R.id.btnSave);
        imageView = view.findViewById(R.id.imgUser);
        this.image_uplaod=imageView;

        btndsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();

                startActivity(new Intent(getContext(), MainActivity.class));

            }
        });

        return view;
    }

    public void set_image(Bitmap image, String image_url)
    {
        imageView.setImageBitmap(image);
        this.image_url=image_url;

    }
}

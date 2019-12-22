package com.besolutions.drnour.local_data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class saved_data {

    public Boolean get_finger_status(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("figer_status",MODE_PRIVATE);
        boolean finger_status=sharedPreferences.getBoolean("figer_status",false);
        return finger_status;
    }

    public String get_image_url(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("image_url",MODE_PRIVATE);
        String delivery_time=sharedPreferences.getString("image_url","0");
        return delivery_time;
    }
    public String get_image_nav(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("image_nav",MODE_PRIVATE);
        String delivery_time=sharedPreferences.getString("image_nav","0");
        return delivery_time;
    }

}

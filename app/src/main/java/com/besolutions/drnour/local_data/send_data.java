package com.besolutions.drnour.local_data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class send_data {

    //FINGERPRINT
    public static void SAVE_FINGER_PRINT(Context context,boolean status)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("figer_status",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("figer_status",status);
        editor.commit();
    }

    public static void SAVE_IMAGE(Context context, String image)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("image_url",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("image_url", image);
        editor.commit();
    }

    public static void SAVE_IMAGE_nav(Context context, String image)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("image_nav",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("image_nav", image);
        editor.commit();
    }

    public static void SAVE_VIDEO_URL(Context context, String image)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("video_url",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("video_url", image);
        editor.commit();
    }


}

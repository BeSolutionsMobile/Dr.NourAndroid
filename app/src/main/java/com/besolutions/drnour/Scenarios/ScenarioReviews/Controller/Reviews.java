package com.besolutions.drnour.Scenarios.ScenarioReviews.Controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;
import com.besolutions.drnour.local_data.send_data;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class Reviews extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout msliderlayout,vsliderlayout;
    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.reviews, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Reviews");
        msliderlayout=(SliderLayout)view.findViewById(R.id.slider);
        msliderlayout.setCustomIndicator((PagerIndicator)view.findViewById(R.id.custom_indicator));
        vsliderlayout = (SliderLayout)view.findViewById(R.id.slidervideo);

        HashMap<String, Integer> photos = new HashMap<String, Integer>();
        photos.put("Cover", R.drawable.slider1);
        photos.put("All Falls Down", R.drawable.slider2);
        photos.put("Dont Leave Me Alone", R.drawable.slider3);
        photos.put("If I Am Lucky", R.drawable.slider4);
        photos.put("My Number One ", R.drawable.slider5);
        photos.put("She Loves Control", R.drawable.slider6);

        for (String name : photos.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());

            textSliderView
                    .image(photos.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            msliderlayout.addSlider(textSliderView);
        }


        HashMap<String, Integer> videos = new HashMap<String, Integer>();
        videos.put("https://www.youtube.com/embed/zAGyUQfEiIg", R.drawable.slider1);
        videos.put("https://www.youtube.com/embed/YCrRA_Eajj8", R.drawable.slider2);
        videos.put("https://www.youtube.com/embed/GEUuPZmw29E", R.drawable.slider3);
        videos.put("https://www.youtube.com/embed/PjsyDeRYSrk", R.drawable.slider4);
        videos.put("https://www.youtube.com/embed/e8ICWzvCRuA ", R.drawable.slider5);
        videos.put("https://www.youtube.com/embed/rZAncKeuLnc", R.drawable.slider6);


        for (String name : videos.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());

            textSliderView
                    .image(videos.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            vsliderlayout.addSlider(textSliderView);
        }
            return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        send_data send_data = new send_data();
        send_data.SAVE_VIDEO_URL(getContext(), String.valueOf(slider.getBundle().get("extra")));
        startActivity(new Intent(getContext(),WebViews.class));


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* switch (item.getItemId()){
            case R.id.action_custom_indicator:
                msliderlayout.setCustomIndicator((PagerIndicator)view.findViewById(R.id.custom_indicator));
                break;
            case R.id.action_custom_child_animation:

                break;
            case R.id.action_restore_default:
                msliderlayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                msliderlayout.setCustomAnimation(new DescriptionAnimation());
                break;
            case R.id.action_github:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
                startActivity(browserIntent);
                break;
        }*/
        return super.onOptionsItemSelected(item);
    }
}

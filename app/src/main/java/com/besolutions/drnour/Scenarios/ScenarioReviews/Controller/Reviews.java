package com.besolutions.drnour.Scenarios.ScenarioReviews.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class Reviews extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout msliderlayout;
    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.reviews, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Reviews");
        msliderlayout=(SliderLayout)view.findViewById(R.id.slider);

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
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            msliderlayout.addSlider(textSliderView);
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
}

package com.besolutions.drnour.Scenarios.ScenarioGallery.Controller;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioAllServices.Pattrens.AllServiceAdapter;
import com.besolutions.drnour.Scenarios.ScenarioGallery.Model.Gallery_Model;
import com.besolutions.drnour.Scenarios.ScenarioGallery.Pattrens.Gallery_Adapter;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class Gallery extends Fragment {


    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.gallery, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Gallery");


        List<Gallery_Model> gallery_modelList = new ArrayList<>();

        int imggallery[] ={R.drawable.slider1,R.drawable.slider2, R.drawable.slider3,
                R.drawable.slider4,R.drawable.slider5,R.drawable.slider6,R.drawable.slider1,R.drawable.slider2,R.drawable.slider3,
                R.drawable.slider4,R.drawable.slider5,R.drawable.slider6};

        String textalbume[] ={"Star Album", "Medical Album", "Tourism Album", "Zaid Clinic Album", "Nacer City Clinic Album","Maadi Clinic Album",
                "Star Album","Orthodontics","Medical Album", "Tourism Album", "Zaid Clinic Album", "Nacer City Clinic Album"};

        for (int i = 0; i<imggallery.length; i++)
        {
            Gallery_Model gallery_model = new Gallery_Model(textalbume[i],imggallery[i]);
            gallery_modelList.add(gallery_model);

        }

        RecyclerView recyclerView = view.findViewById(R.id.rcyGallery);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        Gallery_Adapter adabter = new Gallery_Adapter(gallery_modelList,getContext());
        recyclerView.setAdapter(adabter);

        DividerItemDecoration verticalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.HORIZONTAL);
        Drawable verticalDivider = ContextCompat.getDrawable(getActivity(), R.drawable.vertical_divider_gallery);
        verticalDecoration.setDrawable(verticalDivider);
        recyclerView.addItemDecoration(verticalDecoration);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}

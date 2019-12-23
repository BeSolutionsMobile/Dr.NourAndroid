package com.besolutions.drnour.Scenarios.ScenarioAllServices.Controller;

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
import com.besolutions.drnour.Scenarios.ScenarioAllServices.Model.AllServicesModel;
import com.besolutions.drnour.Scenarios.ScenarioAllServices.Pattrens.AllServiceAdapter;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class All_Service extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.all_service, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("All Services");


        List<AllServicesModel> allServicesList = new ArrayList<>();

        int imgservice[] ={R.drawable.img1,R.drawable.img2, R.drawable.img3,
                R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,
                R.drawable.img10,R.drawable.img11,R.drawable.img12};

        String textservice[] ={"Hollywood Smile", "Pediatric Dentistry", "Laser", "Crowns", "Teeth Whiting","Cosmetic Fillings",
                                "Implament & Oral Surgery","Orthodontics","Hollywood Smile", "Pediatric Dentistry", "Laser", "Crowns"};

        for (int i = 0; i<imgservice.length; i++)
        {
            AllServicesModel model = new AllServicesModel(textservice[i],imgservice[i]);
            allServicesList.add(model);
        }
        RecyclerView recyclerView = view.findViewById(R.id.rcyAllService);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        AllServiceAdapter adabter = new AllServiceAdapter(allServicesList,getContext());
        recyclerView.setAdapter(adabter);

        DividerItemDecoration verticalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.HORIZONTAL);
        Drawable verticalDivider = ContextCompat.getDrawable(getActivity(), R.drawable.vertical_divider);
        verticalDecoration.setDrawable(verticalDivider);
        recyclerView.addItemDecoration(verticalDecoration);

        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        recyclerView.addItemDecoration(horizontalDecoration);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}

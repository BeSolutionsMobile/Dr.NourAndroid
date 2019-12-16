package com.besolutions.drnour.Scenarios.ScenarioResevation.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Model.Reservation_Model;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Pattrens.reservation_adabter;

import java.util.ArrayList;
import java.util.List;

public class My_Reservation extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.my_resevation, container, false);

        List<Reservation_Model> reservation_models = new ArrayList<>();

        String operte[] ={"Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile", "Hollywood Smile"};
        String price[] ={"3000", "3000", "3000","3000", "3000","3000", "3000", "3000","3000", "3000","3000", "3000", "3000","3000","3000"};
        String date[] ={"3/3/2020", "3/3/2020", "3/3/2020","3/3/2020", "3/3/2020", "3/3/2020","3/3/2020", "3/3/2020", "3/3/2020","3/3/2020", "3/3/2020", "3/3/2020","3/3/2020", "3/3/2020", "3/3/2020","3/3/2020", "3/3/2020", "3/3/2020"};

        for (int i=0; i < operte.length; i++)
        {
            Reservation_Model  reservationModel = new Reservation_Model(operte[i],price[i],date[i]);
            reservation_models.add(reservationModel);

        }

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rcyReservation);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        reservation_adabter adabter = new reservation_adabter(reservation_models,getContext());
        recyclerView.setAdapter(adabter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}

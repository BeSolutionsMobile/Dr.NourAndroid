package com.besolutions.drnour.Scenarios.ScenarioReferral.Controller;

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
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;
import com.besolutions.drnour.Scenarios.ScenarioReferral.Model.Referral_Model;
import com.besolutions.drnour.Scenarios.ScenarioReferral.Pattrens.Referral_Adabter;

import java.util.ArrayList;
import java.util.List;

public class My_Referral extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.my_referral, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("My Referral");



        List<Referral_Model> referralList = new ArrayList<>();

        String referralName[] ={"Ahmed Fathi Abd Elazm", "Hend Mohamed Kamal", "Walaa Ali Mostafa Taha", "Hend Ahmed Fouad", "Alla hassan abd elkhalek", "Ali Mohamed Ebrahim ", "Mostafa mansour ali", "Amr Abo Hashema", "Mahmouad mMoahme Gad"};

        for (int i = 0; i<referralName.length; i++)
        {
            Referral_Model referralModel = new Referral_Model(referralName[i]);
            referralList.add(referralModel);
        }

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rcyReferral);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Referral_Adabter adabter = new Referral_Adabter(referralList,getContext());
        recyclerView.setAdapter(adabter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}

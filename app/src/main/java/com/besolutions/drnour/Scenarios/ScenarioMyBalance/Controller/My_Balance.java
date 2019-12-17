package com.besolutions.drnour.Scenarios.ScenarioMyBalance.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;

public class My_Balance extends Fragment {


    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.my_balance, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("My Balance");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}

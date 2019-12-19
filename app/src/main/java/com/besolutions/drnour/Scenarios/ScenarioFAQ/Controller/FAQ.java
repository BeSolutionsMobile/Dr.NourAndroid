package com.besolutions.drnour.Scenarios.ScenarioFAQ.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioFAQ.Model.FAQ_Group1_Model;
import com.besolutions.drnour.Scenarios.ScenarioFAQ.Pattrens.FAQ_Group1_Adapter;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class FAQ extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.faq, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("FAQ");

        String question[] ={"What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications"};
        String answer[] ={"Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev"};

        List<FAQ_Group1_Model> faqGroup1ModelList = new ArrayList<>();
        for (int i = 0; i<question.length; i++)
        {
            FAQ_Group1_Model faq_group1_model = new FAQ_Group1_Model(question[i],answer[i]);
            faqGroup1ModelList.add(faq_group1_model);

        }
        //Group1
        RecyclerView recyclerView1 = view.findViewById(R.id.rcyFaqGroup1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView1.setAdapter(new FAQ_Group1_Adapter(recyclerView1,faqGroup1ModelList));

        //Group2
        RecyclerView recyclerView2 = view.findViewById(R.id.rcyFaqGroup2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.setAdapter(new FAQ_Group1_Adapter(recyclerView2,faqGroup1ModelList));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}

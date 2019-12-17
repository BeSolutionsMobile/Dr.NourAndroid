package com.besolutions.drnour.Scenarios.ScenarioReferral.Pattrens;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioReferral.Controller.Referral_Popup;
import com.besolutions.drnour.Scenarios.ScenarioReferral.Model.Referral_Model;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Controller.Reservation_popup;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Model.Reservation_Model;

import java.util.List;

public class Referral_Adabter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Referral_Model> referral_modelList ;
    Context context;

    public Referral_Adabter(List<Referral_Model> referral_modelList, Context context){

        this.context = context;
        this.referral_modelList = referral_modelList;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.referral_item,parent,false);
        ReferralHolder holder = new ReferralHolder(ads);
        return holder;
        }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder Holder, final int position)
    {
        int viewType = getItemViewType(position);
        final Referral_Model referral_model  = referral_modelList.get(position);


        ReferralHolder referralHolder =(ReferralHolder) Holder;

        referralHolder.textreferral.setText(referral_model.getTextreferrl());


        Holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Referral_Popup dialog = new Referral_Popup();
                dialog.show(((AppCompatActivity)context).getSupportFragmentManager(),"Referral_popup");


            }
        });



       // EnglishSongHolder songHolder =(EnglishSongHolder)Holder;



    }

    @Override
    public int getItemCount()
    {
        return referral_modelList.size();
    }



    public class ReferralHolder extends RecyclerView.ViewHolder
    {
        TextView textreferral;
        public ReferralHolder(@NonNull View itemView)
        {
            super(itemView);
            textreferral = (TextView) itemView.findViewById(R.id.txtReferralName);
        }
    }
}

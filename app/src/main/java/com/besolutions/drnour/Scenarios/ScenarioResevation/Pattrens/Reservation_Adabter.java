package com.besolutions.drnour.Scenarios.ScenarioResevation.Pattrens;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Controller.My_Reservation;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Controller.Reservation_popup;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Model.Reservation_Model;
import java.util.List;

public class Reservation_Adabter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Reservation_Model> reservation_List ;
    Context context;

    public Reservation_Adabter(List<Reservation_Model> reservation_List, Context context){

        this.context = context;
        this.reservation_List = reservation_List;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservision_item,parent,false);
        ReservationHolder holder = new ReservationHolder(ads);
        return holder;
        }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder Holder, final int position)
    {
        int viewType = getItemViewType(position);
        final Reservation_Model songs  = reservation_List.get(position);


        ReservationHolder reservationHolder =(ReservationHolder)Holder;
        reservationHolder.textoperate.setText(songs.getTextoperate());
        reservationHolder.textprice.setText(songs.getTextprice());
        reservationHolder.textdate.setText(songs.getTextdate());

        Holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Reservation_popup dialog = new Reservation_popup();
                dialog.show(((AppCompatActivity)context).getSupportFragmentManager(),"Reservation_popup");


            }
        });



       // EnglishSongHolder songHolder =(EnglishSongHolder)Holder;



    }

    @Override
    public int getItemCount()
    {
        return reservation_List.size();
    }



    public class ReservationHolder extends RecyclerView.ViewHolder
    {
        TextView textoperate, textprice, textdate;
        public ReservationHolder(@NonNull View itemView)
        {
            super(itemView);
            textoperate = (TextView) itemView.findViewById(R.id.txtReservationOperate);
            textprice = (TextView) itemView.findViewById(R.id.txtReservationPrice);
            textdate = (TextView) itemView.findViewById(R.id.txtReservationDate);

        }
    }
}

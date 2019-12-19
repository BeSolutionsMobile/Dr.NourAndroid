package com.besolutions.drnour.Scenarios.ScenarioAllServices.Pattrens;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioAllServices.Controller.All_Service;
import com.besolutions.drnour.Scenarios.ScenarioAllServices.Model.AllServicesModel;
import com.besolutions.drnour.Scenarios.ScenarioServiceInfo.Controller.Service_Info;
import com.bumptech.glide.Glide;
import java.util.List;


public class AllServiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<AllServicesModel> mMainGridList;
    Context mContext;
    private OnItemListener mOnItemListener;

    public AllServiceAdapter(List<AllServicesModel> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_services_item,parent,false);
        MainItemHolder mainHolder = new MainItemHolder(ads) ;
        return mainHolder;
    }

    public class MainHolder extends RecyclerView.ViewHolder{
        public MainHolder(View itemview) {
            super(itemview);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        final AllServicesModel main  = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textService.setText(main.getTxtservice());
        Glide.with(mContext)
                .load(main.getPoster())
                .placeholder(R.drawable.drpicture)
                .into(mainHolder.imgService);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.container,new Service_Info());
                fr.addToBackStack(null);
                fr.commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView textService;
        ImageView imgService;

        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);
            textService = itemView.findViewById(R.id.txtAllService);
            imgService = itemView.findViewById(R.id.imgAllService);


        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}

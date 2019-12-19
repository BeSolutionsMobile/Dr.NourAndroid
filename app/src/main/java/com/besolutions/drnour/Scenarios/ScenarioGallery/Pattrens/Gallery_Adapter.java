package com.besolutions.drnour.Scenarios.ScenarioGallery.Pattrens;

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
import com.besolutions.drnour.Scenarios.ScenarioAllServices.Model.AllServicesModel;
import com.besolutions.drnour.Scenarios.ScenarioGallery.Controller.Gallery;
import com.besolutions.drnour.Scenarios.ScenarioGallery.Model.Gallery_Model;
import com.besolutions.drnour.Scenarios.ScenarioServiceInfo.Controller.Service_Info;
import com.bumptech.glide.Glide;

import java.util.List;


public class Gallery_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<Gallery_Model> mMainGridList;
    Context mContext;
    private OnItemListener mOnItemListener;

    public Gallery_Adapter(List<Gallery_Model> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallary_item,parent,false);
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
        final Gallery_Model main  = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textGallery.setText(main.getTextAlbum());
        Glide.with(mContext)
                .load(main.getImggallery())
                .placeholder(R.drawable.drpicture)
                .into(mainHolder.imgGallery);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                FragmentTransaction fr = ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.container,new Service_Info());
                fr.addToBackStack(null);
                fr.commit();

                 */

            }
        });


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView textGallery;
        ImageView imgGallery;

        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);
            textGallery = itemView.findViewById(R.id.txtGallery);
            imgGallery = itemView.findViewById(R.id.imgGallery);


        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}

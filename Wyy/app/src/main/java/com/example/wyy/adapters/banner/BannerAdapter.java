package com.example.wyy.adapters.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.wyy.R;
import com.example.wyy.classes.BannerClass.Banner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BannerAdapter extends RecyclerView.Adapter<com.example.wyy.adapters.banner.BannerAdapter.ViewHolder> {
    private Map<Integer,Boolean> map=new HashMap<>();
    private List<Banner> bannerList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pic;

        View aSong;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            aSong=itemView;
           pic=itemView.findViewById(R.id.banner_imageView);

        }
    }

    //构造
    public BannerAdapter(List<Banner> findSongs){
        bannerList=findSongs;

    }
    @Override
    public com.example.wyy.adapters.banner.BannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.banner,parent,false);
        com.example.wyy.adapters.banner.BannerAdapter.ViewHolder viewHolder=new com.example.wyy.adapters.banner.BannerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.wyy.adapters.banner.BannerAdapter.ViewHolder holder, int position) {
        Banner banners=bannerList.get(position);
       /* holder.name.setText(findSongs.getName());*/
         Glide.with(holder.aSong.getContext()).load(banners.getPic()).apply(RequestOptions.bitmapTransform(new RoundedCorners(80))).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }
}

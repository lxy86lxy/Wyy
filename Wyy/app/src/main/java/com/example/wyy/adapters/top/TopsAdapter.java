package com.example.wyy.adapters.top;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wyy.R;
import com.example.wyy.classes.TopClass.Top;
import com.example.wyy.main.songs.SongListActivity;
import com.example.wyy.string.Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopsAdapter extends RecyclerView.Adapter<TopsAdapter.ViewHolder> {
    private Map<Integer,Boolean> map=new HashMap<>();
    private List<Top> findSongsList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView coverImgUrl;

        TextView name;
        View aSong;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            aSong=itemView;
            coverImgUrl=itemView.findViewById(R.id.all_find_r3_imageView);
            name=itemView.findViewById(R.id.all_find_r3_textView);
        }
    }

    //构造
    public TopsAdapter(List<Top> findSongs){
        findSongsList=findSongs;

    }
    @Override
    public TopsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_find_r3,parent,false);
        TopsAdapter.ViewHolder viewHolder=new TopsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopsAdapter.ViewHolder holder, int position) {
        Top findSongs=findSongsList.get(position);
        holder.name.setText(findSongs.getName());
        //glide自带圆角
        Glide.with(holder.aSong.getContext()).load(findSongs.getCoverImgUrl()).into(holder.coverImgUrl);
        holder.aSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                Top findSong=findSongsList.get(p);
                Intent intent=new Intent(v.getContext(), SongListActivity.class);
                intent.putExtra(Strings.ID,findSong.getId());
                intent.putExtra("url123",findSong.getCoverImgUrl());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return findSongsList.size();
    }
}

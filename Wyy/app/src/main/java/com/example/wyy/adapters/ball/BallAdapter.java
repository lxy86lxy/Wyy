package com.example.wyy.adapters.ball;

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
import com.example.wyy.classes.BallClass.Ball;
import com.example.wyy.main.top.TopActivity;
import com.example.wyy.main.songs.SongActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallAdapter extends RecyclerView.Adapter<com.example.wyy.adapters.ball.BallAdapter.ViewHolder> {
    private Map<Integer,Boolean> map=new HashMap<>();
    private List<Ball> findSongsList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconUrl;
        TextView name;
        View aSong;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            aSong=itemView;
            iconUrl=itemView.findViewById(R.id.ball_imageView);
        /*    RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(aSong.getResources(), BitmapFactory.decodeResource(aSong.getResources(),R.drawable))*/
            name=itemView.findViewById(R.id.ball_textView);
        }
    }

    //构造
    public BallAdapter(List<Ball> findSongs){
        findSongsList=findSongs;

    }
    @Override
    public com.example.wyy.adapters.ball.BallAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ball,parent,false);
        com.example.wyy.adapters.ball.BallAdapter.ViewHolder viewHolder=new com.example.wyy.adapters.ball.BallAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.wyy.adapters.ball.BallAdapter.ViewHolder holder, int position) {
        Ball findSongs=findSongsList.get(position);
        holder.name.setText(findSongs.getName());
        Glide.with(holder.aSong.getContext()).load(findSongs.getIconUrl()).into(holder.iconUrl);
       holder.aSong.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //圆形点击事件
               int p=holder.getAdapterPosition();
               if(p==2){
                   Intent intent=new Intent(v.getContext(), SongActivity.class);
                   v.getContext().startActivity(intent);
               }
               if (p==3){
                   Intent intent=new Intent(v.getContext(), TopActivity.class);
                   v.getContext().startActivity(intent);
               }
           }
       });
    }

    @Override
    public int getItemCount() {
        return findSongsList.size();
    }
}

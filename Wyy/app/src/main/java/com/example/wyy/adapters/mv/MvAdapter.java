package com.example.wyy.adapters.mv;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wyy.R;
import com.example.wyy.classes.MvClass.Mm;
import com.example.wyy.main.mv.MvActivity;
import com.example.wyy.string.Strings;

import java.util.List;

public class MvAdapter extends RecyclerView.Adapter<MvAdapter.ViewHolder> {

private Activity activity;
private List<Mm> findSongsList;
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
    public MvAdapter(List<Mm> findSongs){
        findSongsList=findSongs;
    }
    @Override
    public MvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_find_r3,parent,false);
        MvAdapter.ViewHolder viewHolder=new MvAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MvAdapter.ViewHolder holder, int position) {
        Mm findSongs=findSongsList.get(position);
        holder.name.setText(findSongs.getName());
        //glide自带圆角
        Glide.with(holder.aSong.getContext()).load(findSongs.getCover()).into(holder.coverImgUrl);
        holder.aSong.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                Mm findSong=findSongsList.get(p);
                Intent intent=new Intent(v.getContext(), MvActivity.class);
                intent.putExtra(Strings.ID,findSong.getId());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return findSongsList.size();
    }
}

package com.example.wyy.adapters.select;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyy.R;
import com.example.wyy.classes.SelectClass.Select;
import com.example.wyy.main.music.MusicActivity;

import java.io.Serializable;
import java.util.List;

public class SelectAdapter extends RecyclerView.Adapter<com.example.wyy.adapters.select.SelectAdapter.ViewHolder> {
    private List<Select> sListList;
   /* private int num=1;*/
    static class ViewHolder extends RecyclerView.ViewHolder{
        RadioButton radioButton;
        RadioButton radioButton1;
        TextView name;
        TextView author;
        TextView number;
        View aSong;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            aSong=itemView;
            name=itemView.findViewById(R.id.songList_name_textView2);
            author=itemView.findViewById(R.id.songList_author_textView3);
            number=itemView.findViewById(R.id.songList_number_textView);
            radioButton=itemView.findViewById(R.id.songList_radioButton);
            radioButton1=itemView.findViewById(R.id.songList_radioButton2);
        }
    }

    //构造
    public SelectAdapter(List<Select>s){
        sListList=s;

    }
    @Override
    public com.example.wyy.adapters.select.SelectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_find_r,parent,false);
        com.example.wyy.adapters.select.SelectAdapter.ViewHolder viewHolder=new com.example.wyy.adapters.select.SelectAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.wyy.adapters.select.SelectAdapter.ViewHolder holder, int position) {
        Select sList=sListList.get(position);
        holder.name.setText(sList.getName());
        holder.author.setText(sList.getAuthor());
        holder.number.setText("🦁");
//        num++;
        holder.aSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                Select sList=sListList.get(p);
                Intent intent=new Intent(v.getContext(), MusicActivity.class);
                intent.putExtra("name",sList.getName());
                intent.putExtra("url",sList.getPicUrl());
                intent.putExtra("id",sList.getMusicId());
                intent.putExtra("position",String.valueOf(p));
                //传递数组
                intent.putExtra("like",(Serializable) sListList);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sListList.size();
    }
}

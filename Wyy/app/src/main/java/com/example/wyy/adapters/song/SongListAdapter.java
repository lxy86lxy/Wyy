package com.example.wyy.adapters.song;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wyy.R;
import com.example.wyy.classes.SongClass.SList;
import com.example.wyy.main.music.Music_Activity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private Map<Integer,Boolean> map=new HashMap<>();
  private List<SList>sListList;
  String url;
//  private int num=1;
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
    static class ZeroViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        ImageView title;
        TextView textView;
        TextView textView2;
        ImageView imageView3;
        View aSong;
        public ZeroViewHolder(@NonNull View itemView){
            super(itemView);
            aSong=itemView;
            textView=itemView.findViewById(R.id.all_find_song_text);
           title=itemView.findViewById(R.id.all_find_song_imageView2);
           imageView3=itemView.findViewById(R.id.all_find_song_imageView3);
           imageView=itemView.findViewById(R.id.all_find_song_imageView);
            textView2=itemView.findViewById(R.id.all_find_song_textView6);
        }
    }
  //构造
    public SongListAdapter(List<SList>s,String url){
      sListList=s;
      this.url=url;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view ;
      if (viewType==0){
          view=LayoutInflater.from(parent.getContext()).inflate(R.layout.all_find_song,parent,false);
          return new ZeroViewHolder(view);
      }else {
          view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_find_r,parent,false);
      }
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    SList sList=sListList.get(position);
    if (holder.getItemViewType()==0){
        ZeroViewHolder zeroViewHolder=(ZeroViewHolder)holder;
        if (sListList.get(0).getTitleImageUrl()=="null"){
            Glide.with(zeroViewHolder.aSong.getContext()).load(url).into(zeroViewHolder.imageView3);

                zeroViewHolder.textView2.setText(sListList.get(0).getDescription());

        }else {
            Glide.with(zeroViewHolder.aSong.getContext()).load(sListList.get(0).getAllPic()).into(zeroViewHolder.imageView);
            Glide.with(zeroViewHolder.aSong.getContext()).load(sListList.get(0).getTitleImageUrl()).into(zeroViewHolder.title);
            if (sListList.get(0).getDescription().length()>30){
                zeroViewHolder.textView.setText(sListList.get(0).getDescription().substring(0,30)+"...");
            }else {
                zeroViewHolder.textView.setText(sListList.get(0).getDescription());
            }
        }


    }
    else{
        ViewHolder viewHolder=(ViewHolder) holder;
        viewHolder.name.setText(sList.getName());
        viewHolder.author.setText(sList.getAuthor());
       viewHolder.number.setText("🐉");
//    num++;
        viewHolder.aSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                SList sList=sListList.get(p);
                Intent intent=new Intent(v.getContext(), Music_Activity.class);
                intent.putExtra("name",sList.getName());
                intent.putExtra("url",sList.getPicUrl());
                intent.putExtra("id",sList.getMusicId());
                intent.putExtra("position",String.valueOf(p));
                //传递数组
                intent.putExtra("love",(Serializable) sListList);
                v.getContext().startActivity(intent);
            }
        });
    }

    }

    @Override
    public int getItemCount() {
        return sListList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else {
            return 1;
        }
    }
}

package com.example.wyy.adapters.word;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyy.R;
import com.example.wyy.classes.lyric.Word;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

private Word word;
private String[] words;
static class ViewHolder extends RecyclerView.ViewHolder{
    TextView lyric;
    View aSong;
    public ViewHolder(@NonNull View itemView){
        super(itemView);
        aSong=itemView;
        lyric=itemView.findViewById(R.id.word_textView);
    }
}

    //构造
    public WordAdapter(String lyric){
        String v=String.valueOf(lyric);
        words=v.split("\\n");
        Log.d("SSSSSssss",words[0]);
    }
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.word,parent,false);
        WordAdapter.ViewHolder viewHolder=new WordAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
       String b=words[position];
//        Log.d("STRINGWORD",b);
       holder.lyric.setText(b.substring(11));
    }

    @Override
    public int getItemCount() {

    return words.length;
    }
}


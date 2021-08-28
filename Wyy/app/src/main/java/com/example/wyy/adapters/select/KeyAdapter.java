package com.example.wyy.adapters.select;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyy.R;
import com.example.wyy.classes.SelectClass.Key;
import com.example.wyy.main.select.SelectKey;

import java.util.List;

public class KeyAdapter extends RecyclerView.Adapter<com.example.wyy.adapters.select.KeyAdapter.ViewHolder> {
    private List<Key> sListList;
    private int num=1;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        View aSong;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            aSong=itemView;
            name=itemView.findViewById(R.id.key_name_textView2);
        }
    }

    //构造
    public KeyAdapter(List<Key>s){
        sListList=s;

    }
    @Override
    public com.example.wyy.adapters.select.KeyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.select_key,parent,false);
        com.example.wyy.adapters.select.KeyAdapter.ViewHolder viewHolder=new com.example.wyy.adapters.select.KeyAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.wyy.adapters.select.KeyAdapter.ViewHolder holder, int position) {
        Key sList=sListList.get(position);
        holder.name.setText(sList.getName());
        holder.aSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                Key sList=sListList.get(p);
                Intent intent=new Intent(v.getContext(), SelectKey.class);
                intent.putExtra("name",sList.getName());
                //传递数组
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sListList.size();
    }
}

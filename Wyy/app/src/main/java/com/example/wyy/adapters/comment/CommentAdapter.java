package com.example.wyy.adapters.comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.wyy.R;
import com.example.wyy.classes.CommentClass.Comments;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
private List<Comments> commentList;
static class ViewHolder extends RecyclerView.ViewHolder{
    ImageView avatarUrl;
    TextView content;
    TextView nickname;
    View aSong;
    public ViewHolder(@NonNull View itemView){
        super(itemView);
        aSong=itemView;
        content=itemView.findViewById(R.id.comment_textView2);
        avatarUrl=itemView.findViewById(R.id.comment_image);
        nickname=itemView.findViewById(R.id.comment_text1);
    }
}

    //构造
    public CommentAdapter(List<Comments> findSongs){
        commentList=findSongs;

    }
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.comment,parent,false);
        CommentAdapter.ViewHolder viewHolder=new CommentAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        Comments comment=commentList.get(position);
        holder.nickname.setText(comment.getNickname());
        holder.content.setText(comment.getContent());
        //glide自带圆角
        Glide.with(holder.aSong.getContext()).load(comment.getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.avatarUrl);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}

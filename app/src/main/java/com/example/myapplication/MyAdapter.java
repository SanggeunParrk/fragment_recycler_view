package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<FriendData> mDataset;
    private String nick;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_NickName;
        public TextView TextView_Msg;
        public MyViewHolder(View v) {
            super(v);
            TextView_NickName=v.findViewById(R.id.TextView_NickName);
            TextView_Msg=v.findViewById(R.id.TextView_Msg);
        }
    }

    public MyAdapter(List<FriendData> myDataset, String nick) {
        mDataset = myDataset;
        this.nick=nick;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        FriendData chat = mDataset.get(position);
        holder.TextView_NickName.setText(chat.getNickName());
        holder.TextView_Msg.setText(chat.getMsg());
        if(nick.equals(chat.getNickName())){
            holder.TextView_NickName.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            holder.TextView_Msg.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        }

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_row, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return mDataset != null ? mDataset.size() : 0;
    }
}

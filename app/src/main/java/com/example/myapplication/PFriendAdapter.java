package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PFriendAdapter extends RecyclerView.Adapter<PFriendAdapter.PFriendViewHolder> {
    private List<PFriendData> pDataset;
    private String pNick;
    public PFriendViewHolder pFriendViewHolder;
    public Button btn;

    public static class PFriendViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView pTextViewNickName;
        public TextView pTextViewMsg;
        public Button btn;
        public PFriendViewHolder(View v) {
            super(v);
            pTextViewNickName=v.findViewById(R.id.pTextViewNickName);
            pTextViewMsg=v.findViewById(R.id.pTextViewMsg);
            btn=v.findViewById(R.id.btn);
        }
    }

    public PFriendAdapter(List<PFriendData> Dataset, String nick) {
        pDataset = Dataset;
        this.pNick=nick;
    }
    @Override
    public void onBindViewHolder(PFriendViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        PFriendData pFriendData = pDataset.get(position);
        holder.pTextViewNickName.setText(pFriendData.getNickName());
        holder.pTextViewMsg.setText(pFriendData.getMsg());

    }

    @NonNull
    @Override
    public PFriendAdapter.PFriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.p_friend_row, parent, false);
        PFriendViewHolder vh = new PFriendViewHolder(v);
        pFriendViewHolder = vh;
        btn = vh.btn;
        return vh;
    }



    @Override
    public int getItemCount() {
        return pDataset != null ? pDataset.size() : 0;
    }
}

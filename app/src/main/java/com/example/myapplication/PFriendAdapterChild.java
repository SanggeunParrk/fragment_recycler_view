package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PFriendAdapterChild extends RecyclerView.Adapter<PFriendAdapterChild.PFriendViewHolder> {
    private ArrayList<PFriendData> pDataset;
    private String pNick;
    public PFriendViewHolder pFriendViewHolder;
    public Button btn;

    public static class PFriendViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView pTextViewNickName;
        public TextView pTextViewMsg;
        public LinearLayout pLinearLayout;
        public Button btn;
        public PFriendViewHolder(View v) {
            super(v);
            pTextViewNickName=v.findViewById(R.id.pTextViewNickName);
            pTextViewMsg=v.findViewById(R.id.pTextViewMsg);
            pLinearLayout = v.findViewById(R.id.pLinearLayout);
            pLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"성공! Child", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public PFriendAdapterChild(List<PFriendData> Dataset, int tag){
        pDataset = new ArrayList<>();
        if(tag==0){
            for(PFriendData element : Dataset){
                if(element.getpBirthday() == 3 )    pDataset.add(element);
            }
        }
        else if (tag==1){
            for(PFriendData element : Dataset){
                if(element.getpBirthday() == 1 )    pDataset.add(element);
            }
        }
        else if (tag==2){
            for(PFriendData element : Dataset){
                if(element.getpBirthday() == 4 )    pDataset.add(element);
            }
        }
        else if (tag==3){
            for(PFriendData element : Dataset){
                if(element.getpBirthday() == 1 )    pDataset.add(element);
            }
        }
        else if (tag==4){
            for(int i=1;i<10;i++){
                pDataset.add(new PFriendData(i));
            }
        }
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
    public PFriendAdapterChild.PFriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

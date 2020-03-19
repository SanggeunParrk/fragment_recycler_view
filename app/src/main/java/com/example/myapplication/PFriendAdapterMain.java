package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PFriendAdapterMain extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PFriendData> pDataset;
//    public PFriendDefaultViewHolder pFriendDefaultViewHolder;
    public PFienndScrollDisabledRecyclerViewHolder pFriendScrollDisabledListViewHolder;
    public PFirendBarViewHolder pFirendBarViewHolder;

    private static int P_TYPE_DEFAULT = 0;
    private static int P_TYPE_BAR =1;
    private static int P_TYPE_SCROLL_DISABLED_RECYCLER_VIEW = 2;


//    public static class PFriendDefaultViewHolder extends RecyclerView.ViewHolder {
//        public TextView pTextViewNickName;
//        public TextView pTextViewMsg;
//        public Button btn;
//        public PFriendDefaultViewHolder(View v) {
//            super(v);
//            pTextViewNickName=v.findViewById(R.id.pTextViewNickName);
//            pTextViewMsg=v.findViewById(R.id.pTextViewMsg);
//        }
//    }

    public static class PFirendBarViewHolder extends RecyclerView.ViewHolder{
        public TextView         pFriendBarText;
        public RelativeLayout   pButtonFriend;
        public ImageView        pImageFriendDown,pImageFriendUp;
        public int              pButtonVisibility=0;
        public PFirendBarViewHolder(View v){
            super(v);
            pFriendBarText = v.findViewById(R.id.pFriendBarText);
            pButtonFriend = v.findViewById(R.id.pButtonFriend);
            pImageFriendUp = v.findViewById(R.id.pImageFriendUp);
            pImageFriendDown = v.findViewById(R.id.pImageFriendDown);
            pImageFriendUp.setVisibility(View.INVISIBLE);
            pButtonFriend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"성공!",Toast.LENGTH_LONG).show();
                    if(pButtonVisibility==0) {
                        pImageFriendDown.setVisibility(View.INVISIBLE);
                        pImageFriendUp.setVisibility(View.VISIBLE);
                        pButtonVisibility=1;
                    }
                    else{

                        pImageFriendUp.setVisibility(View.INVISIBLE);
                        pImageFriendDown.setVisibility(View.VISIBLE);
                        pButtonVisibility=0;
                    }
                }
            });
        }
    }

    public static class PFienndScrollDisabledRecyclerViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView pFriendChildRecyclerView;
        public String tag;

        public PFienndScrollDisabledRecyclerViewHolder(View v){
            super(v);
            pFriendChildRecyclerView = v.findViewById(R.id.pFriendChildRecyclerView);
            pFriendChildRecyclerView.setHasFixedSize(false);
            RecyclerView.LayoutManager pLayoutManagerChild;
            pLayoutManagerChild = new CustomLinearLayoutManager(v.getContext());
            pFriendChildRecyclerView.setLayoutManager(pLayoutManagerChild);
        }
    }

    public PFriendAdapterMain(List<PFriendData> Dataset, String nick) {
        pDataset = Dataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v;
//        if(viewType == P_TYPE_DEFAULT){
//            v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.p_friend_row, parent, false);
//            PFriendDefaultViewHolder vh = new PFriendDefaultViewHolder(v);
//            return vh;
//        }
        if(viewType == P_TYPE_BAR) {
            v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.p_friend_bar, parent, false);
            PFirendBarViewHolder vh = new PFirendBarViewHolder(v);
            return vh;
        }
        else{
            v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.p_friend_child_recycler_view, parent, false);
            PFienndScrollDisabledRecyclerViewHolder vh = new PFienndScrollDisabledRecyclerViewHolder(v);
            return vh;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        if(getItemViewType(position)==P_TYPE_DEFAULT){
//            ((PFriendDefaultViewHolder) holder).pTextViewNickName.setText(pDataset.get(position).getNickName());
//            ((PFriendDefaultViewHolder) holder).pTextViewMsg.setText(pDataset.get(position).getMsg());
//        }
        if(getItemViewType(position)==P_TYPE_BAR){
            ((PFirendBarViewHolder) holder).pFriendBarText.setText(pDataset.get(position).getpBarText());
        }
        else if(getItemViewType(position)==P_TYPE_SCROLL_DISABLED_RECYCLER_VIEW){
            int ViewTag = pDataset.get(position).getpChildViewType();
            PFriendAdapterChild pAdapterChild;
            pAdapterChild = new PFriendAdapterChild(pDataset,ViewTag);
            ((PFienndScrollDisabledRecyclerViewHolder) holder).pFriendChildRecyclerView.setAdapter(pAdapterChild);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return pDataset.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return pDataset != null ? pDataset.size() : 0;
    }
}

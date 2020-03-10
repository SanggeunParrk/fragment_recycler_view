package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PFriendFragment extends Fragment {
    private RecyclerView                pRecyclerView;
    private RecyclerView.Adapter        pAdapter;
    private RecyclerView.LayoutManager  pLayoutManager;
    private ArrayList<PFriendData>      pDataset;
    private String                      NICK = "nick";
    private LinearLayout                pLinearLayoutChat;
    private PFriendShortClickFragment   pFriendShortClickFragment;

    Button btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.p_friend_fragment_main,container,false);
        pDataset = new ArrayList<>();
        pDataset.add(new PFriendData());

        pRecyclerView = (RecyclerView) rootView.findViewById(R.id.pRecyclerView);

        pRecyclerView.setHasFixedSize(true);


        // use a linear layout manager
        pLayoutManager = new LinearLayoutManager(getActivity());
        pRecyclerView.setLayoutManager(pLayoutManager);


        // specify an adapter (see also next example)
        pAdapter = new PFriendAdapter(pDataset,NICK);
        pRecyclerView.setAdapter(pAdapter);

        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pRecyclerView = (RecyclerView) view.findViewById(R.id.pRecyclerView);
        PFriendAdapter pFriendAdapter = (PFriendAdapter) pRecyclerView.getAdapter();
        Button btn = pFriendAdapter.btn;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pFriendShortClickFragment = new PFriendShortClickFragment();
                getChildFragmentManager().beginTransaction().add(R.id.mContainer,pFriendShortClickFragment).commit();
            }
        });


    }


}

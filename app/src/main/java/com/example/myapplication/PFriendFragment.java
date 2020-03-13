package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PFriendFragment extends Fragment {
    private RecyclerView                pRecyclerViewMain,pRecyclerViewBirthday;
    private RecyclerView.Adapter        pAdapterMain,pAdapterBirthday;
    private RecyclerView.LayoutManager  pLayoutManagerMain,pLayoutManagerBirthday;
    private ArrayList<PFriendData>      pDataset;
    private String                      NICK = "nick";
    private LinearLayout                pLinearLayoutChat;
    private RelativeLayout              pButtonBirthday;
    private PFriendShortClickFragment   pFriendShortClickFragment;
    private String                      TAG_BIRTHDAY = "birthday";
    private ImageView                   pImageBirthdayDown,pImageBirthdayUp;
    private int                         State_Birthday;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.p_friend_fragment_main,container,false);
        pDataset = new ArrayList<>();
        for(int i=1;i<10;i++){
            pDataset.add(new PFriendData(i));
        }
        State_Birthday = 0;
        pImageBirthdayDown = rootView.findViewById(R.id.pImageBirthdayDown);
        pImageBirthdayUp   = rootView.findViewById(R.id.pImageBirthdayUp);
        pImageBirthdayUp.setVisibility(View.INVISIBLE);
        //MainRecyclerView : 메인리사이클러뷰 - 친구창
            pRecyclerViewMain = (RecyclerView) rootView.findViewById(R.id.pRecyclerViewMain);
            pRecyclerViewMain.setHasFixedSize(true);
            pLayoutManagerMain = new LinearLayoutManager(getActivity());
            pRecyclerViewMain.setLayoutManager(pLayoutManagerMain);
            pAdapterMain = new PFriendAdapterMain(pDataset,NICK);
            pRecyclerViewMain.setAdapter(pAdapterMain);

        //BirthdayRecyclerView : 생일 리사이클러뷰
            pRecyclerViewBirthday = (RecyclerView) rootView.findViewById(R.id.pRecyclerViewBirthday);
            pRecyclerViewBirthday.setHasFixedSize(true);
            pLayoutManagerBirthday = new LinearLayoutManager(getActivity());
            pRecyclerViewBirthday.setLayoutManager(pLayoutManagerBirthday);
            pAdapterBirthday = new PFriendAdapterBirthday(pDataset,NICK,TAG_BIRTHDAY);
            pRecyclerViewBirthday.setAdapter(pAdapterBirthday);

        pButtonBirthday = rootView.findViewById(R.id.pButtonBirthday);
        pButtonBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (State_Birthday == 0) {
                            pRecyclerViewBirthday.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.p_birthday_slide_up));
                            pRecyclerViewMain.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.p_birthday_other_slide_up));
                        State_Birthday = 1;
                        pImageBirthdayDown.setVisibility(View.INVISIBLE);
                        pImageBirthdayUp.setVisibility(View.VISIBLE);
                } else {
                            pRecyclerViewBirthday.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.p_birthday_slide_down));
                            pRecyclerViewMain.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.p_birthday_other_slide_down));
                    State_Birthday = 0;
                        pImageBirthdayUp.setVisibility(View.INVISIBLE);
                        pImageBirthdayDown.setVisibility(View.VISIBLE);
                }
            }
        });
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

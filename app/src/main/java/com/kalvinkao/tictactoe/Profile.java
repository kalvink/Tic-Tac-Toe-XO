package com.kalvinkao.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Profile extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment

        final Button btn_back = root.findViewById(R.id.btn_back);


        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                }


            }
        });

        return root;
    }


}



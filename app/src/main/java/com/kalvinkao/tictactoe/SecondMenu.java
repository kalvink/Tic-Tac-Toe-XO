package com.kalvinkao.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

public class SecondMenu extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View root = inflater.inflate(R.layout.fragment_menu_two, container, false);
        // Inflate the layout for this fragment

        final Button btn_back = root.findViewById(R.id.btn_back);
        final Button btn_vs2player = root.findViewById(R.id.btn_vs2player);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment mFragment = null;
                mFragment = new FirstMenu();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();
            }
        });
        btn_vs2player.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment mFragment = null;
                mFragment = new GamePVP();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();
            }
        });

        return root;
    }


}
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

public class FirstMenu extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        // Inflate the layout for this fragment

        final Button btn_first = root.findViewById(R.id.button_first);

        btn_first.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment mFragment = null;
                mFragment = new SecondMenu();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();
            }
        });
        return root;
    }
}
package com.kalvinkao.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Matchmaking extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View root = inflater.inflate(R.layout.fragment_matchmaking, container, false);
        // Inflate the layout for this fragment
        final Button btn_back = root.findViewById(R.id.btn_back);
        final TextView players_search = root.findViewById(R.id.players_searching);
        TextView e_time = root.findViewById(R.id.estimated_time3);
        final TextView q_time = root.findViewById(R.id.queue_time2);
        final TextView players_online = root.findViewById(R.id.players_online);
        final TextView search = root.findViewById(R.id.searching);

        Thread thread = new Thread() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void run() {
                int seconds = 0;
                int minutes = 0;

                for (int i = 0; i <= 3; i++) {
                    if (i == 0) {
                        search.setText("SEARCHING");
                    }
                    if (i == 1) {
                        search.setText("SEARCHING.");
                    }
                    if (i == 2) {
                        search.setText("SEARCHING..");
                    }
                    if (i == 3) {
                        search.setText("SEARCHING...");
                        i = -1;
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seconds++;
                    minutes = minutes + seconds / 60;
                    if (seconds == 60) {
                        seconds = 0;
                    }
                    q_time.setText(String.format("%d:%02d", minutes, seconds));
                    players_search.setText("PLAYERS SEARCHING: " + Profile.players_searching);
                    players_online.setText("(Online: " + Profile.players_online + ")");
                }
            }
        };
        thread.start();

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                assert fm != null;
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                }
                Profile.mm.setClickable(true);
                Profile.lb.setClickable(true);
                Profile.sign_out.setClickable(true);

            }
        });


        return root;

    }

}

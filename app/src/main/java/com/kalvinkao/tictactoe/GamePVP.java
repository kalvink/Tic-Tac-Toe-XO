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

public class GamePVP extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View root = inflater.inflate(R.layout.fragment_game_pvp, container, false);
        // Inflate the layout for this fragment

        final Button btn_back = root.findViewById(R.id.btn_back);
        final Button btn1 = root.findViewById(R.id.button1);
        final Button btn2 = root.findViewById(R.id.button2);
        final Button btn3 = root.findViewById(R.id.button3);
        final Button btn4 = root.findViewById(R.id.button4);
        final Button btn5 = root.findViewById(R.id.button5);
        final Button btn6 = root.findViewById(R.id.button6);
        final Button btn7 = root.findViewById(R.id.button7);
        final Button btn8 = root.findViewById(R.id.button8);
        final Button btn9 = root.findViewById(R.id.button9);

        //player X turn
        final boolean[] playerX = {true};


        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment mFragment = null;
                mFragment = new SecondMenu();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn1.setText("X");
                    playerX[0] = false;
                } else {
                    btn1.setText("O");
                    playerX[0] = true;
                }
                btn1.setClickable(false);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn2.setText("X");
                    playerX[0] = false;
                } else {
                    btn2.setText("O");
                    playerX[0] = true;
                }
                btn2.setClickable(false);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn3.setText("X");
                    playerX[0] = false;
                } else {
                    btn3.setText("O");
                    playerX[0] = true;
                }
                btn3.setClickable(false);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn4.setText("X");
                    playerX[0] = false;
                } else {
                    btn4.setText("O");
                    playerX[0] = true;
                }
                btn4.setClickable(false);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn5.setText("X");
                    playerX[0] = false;
                } else {
                    btn5.setText("O");
                    playerX[0] = true;
                }
                btn5.setClickable(false);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn6.setText("X");
                    playerX[0] = false;
                } else {
                    btn6.setText("O");
                    playerX[0] = true;
                }
                btn6.setClickable(false);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn7.setText("X");
                    playerX[0] = false;
                } else {
                    btn7.setText("O");
                    playerX[0] = true;
                }
                btn7.setClickable(false);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn8.setText("X");
                    playerX[0] = false;
                } else {
                    btn8.setText("O");
                    playerX[0] = true;
                }
                btn8.setClickable(false);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    btn9.setText("X");
                    playerX[0] = false;
                } else {
                    btn9.setText("O");
                    playerX[0] = true;
                }
                btn9.setClickable(false);
            }
        });

        return root;
    }
}
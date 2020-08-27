package com.kalvinkao.tictactoe;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Arrays;


public class GamePVP extends Fragment {

    static boolean Xwin = false;
    static boolean Owin = false;
    static boolean draw = false;
    int Xwin_count = 0;
    int Owin_count = 0;
    int draw_count = 0;
    static final int[][] grid = new int[3][3];

    //player X turn
    static final boolean[] playerX = {true};

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Xwin = false;
        Owin = false;
        draw = false;
        final View root = inflater.inflate(R.layout.fragment_game_pvp, container, false);
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
        final TextView txt_Xwins = (TextView) root.findViewById(R.id.Xwins);
        final TextView txt_Owins = (TextView) root.findViewById(R.id.Owins);
        final TextView txt_ties = (TextView) root.findViewById(R.id.ties);
        final TextView txt_turn = (TextView) root.findViewById(R.id.text_turn);
        for (int[] ints : grid) {
            Arrays.fill(ints, 2);
        }


        AdView mAdViewBot = (AdView) root.findViewById(R.id.adViewBot);
        //AdView mAdViewSide = findViewById(R.id.adViewSide);
        AdRequest adRequest = new AdRequest.Builder().build();
        if (MainActivity.ads_on) {
            mAdViewBot.loadAd(adRequest);
            //  mAdViewSide.loadAd(adRequest);
        }


        //Back Btn
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment mFragment = null;
                mFragment = new SecondMenu();
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();
                enableGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                playerX[0] = true;
            }
        });


        //Buttons 1-9 on the grid XO
        btn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    txt_turn.setText("Player 2 (O)'s Turn");

                    btn1.setText("X");
                    playerX[0] = false;
                    grid[0][0] = 0;
                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");

                    btn1.setText("O");
                    playerX[0] = true;
                    grid[0][0] = 1;
                }
                btn1.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    btn2.setText("X");
                    playerX[0] = false;
                    grid[0][1] = 0;
                    txt_turn.setText("Player 2 (O)'s Turn");

                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");
                    btn2.setText("O");
                    playerX[0] = true;
                    grid[0][1] = 1;
                }
                btn2.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);

                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    txt_turn.setText("Player 2 (O)'s Turn");
                    btn3.setText("X");
                    playerX[0] = false;
                    grid[0][2] = 0;

                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");
                    btn3.setText("O");
                    playerX[0] = true;
                    grid[0][2] = 1;
                }
                btn3.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);

                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    txt_turn.setText("Player 2 (O)'s Turn");
                    btn4.setText("X");
                    playerX[0] = false;
                    grid[1][0] = 0;

                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");
                    btn4.setText("O");
                    playerX[0] = true;
                    grid[1][0] = 1;
                }
                btn4.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);

                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    txt_turn.setText("Player 2 (O)'s Turn");
                    btn5.setText("X");
                    playerX[0] = false;
                    grid[1][1] = 0;

                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");
                    btn5.setText("O");
                    playerX[0] = true;
                    grid[1][1] = 1;

                }
                btn5.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);

                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    txt_turn.setText("Player 2 (O)'s Turn");
                    btn6.setText("X");
                    playerX[0] = false;
                    grid[1][2] = 0;

                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");
                    btn6.setText("O");
                    playerX[0] = true;
                    grid[1][2] = 1;

                }
                btn6.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);

                }

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    txt_turn.setText("Player 2 (O)'s Turn");
                    btn7.setText("X");
                    playerX[0] = false;
                    grid[2][0] = 0;

                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");
                    btn7.setText("O");
                    playerX[0] = true;
                    grid[2][0] = 1;

                }
                btn7.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);

                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    txt_turn.setText("Player 2 (O)'s Turn");
                    btn8.setText("X");
                    playerX[0] = false;
                    grid[2][1] = 0;

                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");
                    btn8.setText("O");
                    playerX[0] = true;
                    grid[2][1] = 1;

                }
                btn8.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                if (playerX[0]) {
                    txt_turn.setText("Player 2 (O)'s Turn");
                    btn9.setText("X");
                    playerX[0] = false;
                    grid[2][2] = 0;

                } else {
                    txt_turn.setText("Player 1 (X)'s Turn");
                    btn9.setText("O");
                    playerX[0] = true;
                    grid[2][2] = 1;

                }
                btn9.setClickable(false);
                if (checkWins(txt_Xwins, txt_Owins, txt_ties, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)) {
                    endGame(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    popupWindow(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, txt_turn, btn_back);


                }
            }
        });

        return root;
    }

    @SuppressLint("SetTextI18n")
    public void popupWindow(final Button a, final Button b, final Button c, final Button d, final Button e, final Button f, final Button g, final Button h, final Button i, final TextView turn, final Button btn_back) {
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.endgame, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(false);

        TextView popup_msg = (TextView) popupView.findViewById(R.id.popup_message);

        if (Xwin) {
            popup_msg.setText("PLAYER 1 WINS");
        } else if (Owin) {
            popup_msg.setText("PLAYER 2 WINS");
        } else {
            popup_msg.setText("DRAW");
        }
        btn_back.setClickable(false);
        Button new_game = popupView.findViewById(R.id.btn_newgame);
        new_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playerX[0]) {
                    turn.setText("Player 1 (X)'s Turn");
                } else
                    turn.setText("Player 2 (O)'s Turn");
                enableGame(a, b, c, d, e, f, g, h, i);
                popupWindow.dismiss();
                btn_back.setClickable(true);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean checkWins(TextView txta, TextView txtb, TextView txtc, Button a, Button b, Button c, Button d, Button e, Button f, Button g, Button h, Button i) {
        //Check for horizontal wins
        boolean endGame = false;

        if (grid[0][0] == 0 && grid[0][1] == 0 && grid[0][2] == 0) {
            Xwin = true;
            a.setTextColor(0xFF008000);
            b.setTextColor(0xFF008000);
            c.setTextColor(0xFF008000);
        } else if (grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1) {
            Owin = true;
            a.setTextColor(0xFF008000);
            b.setTextColor(0xFF008000);
            c.setTextColor(0xFF008000);
        } else if (grid[1][0] == 0 && grid[1][1] == 0 && grid[1][2] == 0) {
            Xwin = true;
            d.setTextColor(0xFF008000);
            e.setTextColor(0xFF008000);
            f.setTextColor(0xFF008000);
        } else if (grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1) {
            Owin = true;
            d.setTextColor(0xFF008000);
            e.setTextColor(0xFF008000);
            f.setTextColor(0xFF008000);
        } else if (grid[2][0] == 0 && grid[2][1] == 0 && grid[2][2] == 0) {
            Xwin = true;
            g.setTextColor(0xFF008000);
            h.setTextColor(0xFF008000);
            i.setTextColor(0xFF008000);
        } else if (grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1) {
            Owin = true;
            g.setTextColor(0xFF008000);
            h.setTextColor(0xFF008000);
            i.setTextColor(0xFF008000);
        }
        // Check for vertical wins
        else if (grid[0][0] == 0 && grid[1][0] == 0 && grid[2][0] == 0) {
            Xwin = true;
            a.setTextColor(0xFF008000);
            d.setTextColor(0xFF008000);
            g.setTextColor(0xFF008000);
        } else if (grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1) {
            Owin = true;
            a.setTextColor(0xFF008000);
            d.setTextColor(0xFF008000);
            g.setTextColor(0xFF008000);
        } else if (grid[0][1] == 0 && grid[1][1] == 0 && grid[2][1] == 0) {
            Xwin = true;
            b.setTextColor(0xFF008000);
            e.setTextColor(0xFF008000);
            h.setTextColor(0xFF008000);
        } else if (grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1) {
            Owin = true;
            b.setTextColor(0xFF008000);
            e.setTextColor(0xFF008000);
            h.setTextColor(0xFF008000);
        } else if (grid[0][2] == 0 && grid[1][2] == 0 && grid[2][2] == 0) {
            Xwin = true;
            c.setTextColor(0xFF008000);
            f.setTextColor(0xFF008000);
            i.setTextColor(0xFF008000);
        } else if (grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1) {
            Owin = true;
            c.setTextColor(0xFF008000);
            f.setTextColor(0xFF008000);
            i.setTextColor(0xFF008000);
        }
        //Check for diagonal wins
        else if (grid[0][0] == 0 && grid[1][1] == 0 && grid[2][2] == 0) {
            Xwin = true;
            a.setTextColor(0xFF008000);
            e.setTextColor(0xFF008000);
            i.setTextColor(0xFF008000);
        } else if (grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1) {
            Owin = true;
            a.setTextColor(0xFF008000);
            e.setTextColor(0xFF008000);
            i.setTextColor(0xFF008000);
        } else if (grid[0][2] == 0 && grid[1][1] == 0 && grid[2][0] == 0) {
            Xwin = true;
            c.setTextColor(0xFF008000);
            e.setTextColor(0xFF008000);
            g.setTextColor(0xFF008000);
        } else if (grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 1) {
            Owin = true;
            c.setTextColor(0xFF008000);
            e.setTextColor(0xFF008000);
            g.setTextColor(0xFF008000);
        }
        //Check for ties... runs the method
        else if (!Owin && !Xwin && !checkTies(2)) {
            draw = true;
        }

        //Update Win/Draw Counters
        if (Xwin) {
            Xwin_count++;
            txta.setText(String.valueOf(Xwin_count));
            endGame = true;
        } else if (Owin) {
            Owin_count++;
            txtb.setText(String.valueOf(Owin_count));
            endGame = true;
        } else if (draw) {
            draw_count++;
            txtc.setText(String.valueOf(draw_count));
            endGame = true;
        }

        return endGame;
    }

    //Check Ties
    public boolean checkTies(int val) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == val) return true;
            }
        }
        return false;
    }

    public static void endGame(Button a, Button b, Button c, Button d, Button e, Button f, Button g, Button h, Button i) {
        a.setClickable(false);
        b.setClickable(false);
        c.setClickable(false);
        d.setClickable(false);
        e.setClickable(false);
        f.setClickable(false);
        g.setClickable(false);
        h.setClickable(false);
        i.setClickable(false);
    }

    public static void enableGame(Button a, Button b, Button c, Button d, Button e, Button f, Button g, Button h, Button i) {

        a.setClickable(true);
        b.setClickable(true);
        c.setClickable(true);
        d.setClickable(true);
        e.setClickable(true);
        f.setClickable(true);
        g.setClickable(true);
        h.setClickable(true);
        i.setClickable(true);
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        e.setText("");
        f.setText("");
        g.setText("");
        h.setText("");
        i.setText("");
        a.setTextColor(0xFF000000);
        b.setTextColor(0xFF000000);
        c.setTextColor(0xFF000000);
        d.setTextColor(0xFF000000);
        e.setTextColor(0xFF000000);
        f.setTextColor(0xFF000000);
        g.setTextColor(0xFF000000);
        h.setTextColor(0xFF000000);
        i.setTextColor(0xFF000000);
        Xwin = false;
        Owin = false;
        draw = false;
        for (int[] ints : grid) {
            Arrays.fill(ints, 2);
        }

    }

}
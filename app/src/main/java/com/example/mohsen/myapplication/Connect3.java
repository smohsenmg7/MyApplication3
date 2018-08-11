package com.example.mohsen.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Connect3 extends AppCompatActivity {
    public static final int blue = 0;
    public static final int RED = 1;
    public static final int NOT_PLAYED = 2;
    public static final int NO_WINNER = -1;
    public static int activePlayer = blue;
    public static int winner = NO_WINNER;
    RelativeLayout winMessage;
    ImageView winIcon;
    TextView winMessageText;
    int[] gameState = {NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
            NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
            NOT_PLAYED, NOT_PLAYED, NOT_PLAYED};
    int[][] winningPosition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);
        winIcon = findViewById(R.id.winner_icon);
        winMessage = findViewById(R.id.win_message);
        winMessageText = findViewById(R.id.win_message_text);


    }


    public void dropIn(View view) {
        String tag = view.getTag().toString();
        int tagNumber = Integer.parseInt(tag);
        if (gameState[tagNumber] != NOT_PLAYED) {
            return;
        }
        ImageView img = (ImageView) view;

        if (activePlayer == RED) {
            gameState[tagNumber] = RED;
            img.setImageResource(R.drawable.red);
            activePlayer = blue;
        } else {
            img.setImageResource(R.drawable.blue);
            gameState[tagNumber] = blue;
            activePlayer = RED;
        }
        img.setAlpha(0f);
        img.animate().alpha(1f).setDuration(1000);

        winner = checkWinner();
        if (winner != NO_WINNER || filled()) {


            if (winner == NO_WINNER) {
                winMessage.setVisibility(View.VISIBLE);
                winMessageText.setText("Nobody\n win");
            } else if (winner == RED) {
                winMessage.setVisibility(View.VISIBLE);
                winIcon.setImageResource(R.drawable.red);
            } else if (winner == blue) {
                winMessage.setVisibility(View.VISIBLE);
                winIcon.setImageResource(R.drawable.blue);
            }
        }
    }

    public void resetGame(View view) {
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = NOT_PLAYED;
        }
        activePlayer = RED;
        winner = NO_WINNER;
        LinearLayout pgLayout = (LinearLayout) findViewById(R.id.pg_layout);
        for (int i = 0; i < pgLayout.getChildCount(); i++) {
            LinearLayout row = (pgLayout.getChildAt(i)) instanceof LinearLayout ?
                    (LinearLayout) pgLayout.getChildAt(i) : null;
            if (row == null) {
                return;
            }
            for (int j = 0; j < row.getChildCount(); j++) {
                ImageView img = (row.getChildAt(j)) instanceof ImageView ?
                        (ImageView) row.getChildAt(j) : null;
                img.setImageResource(0);
            }
        }
        if (winMessage.getVisibility() == View.VISIBLE) {
            winMessage.setVisibility(View.INVISIBLE);
            winMessageText.setText("Winner:");
            winIcon.setImageResource(0);
        }

    }

    public boolean filled() {
        for (int i = 0; i < gameState.length; i++) {
            if (gameState[i] == NOT_PLAYED) {
                return false;
            }
        }
        return true;
    }

    public int checkWinner() {
        for (int[] position : winningPosition) {
            if (gameState[position[0]] == gameState[position[1]] &&
                    gameState[position[1]] == gameState[position[2]] &&
                    gameState[position[0]] != NOT_PLAYED) {
                return gameState[position[0]];
            }
        }
        return NO_WINNER;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add("reset");
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                resetGame(null);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}


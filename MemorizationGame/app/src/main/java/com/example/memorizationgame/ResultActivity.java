package com.example.memorizationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //setting music
        final Intent serviceIntent = new Intent(ResultActivity.this,MusicService.class);
        ImageButton musicPlayer = (ImageButton)findViewById(R.id.sound);
        if(MusicService.isplay == false){
            musicPlayer.setImageResource(R.drawable.start);
        }
        musicPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MusicService.isplay == false){
                    startService(serviceIntent);
                    musicPlayer.setImageResource(R.drawable.stop);
                }else {
                    stopService(serviceIntent);
                    musicPlayer.setImageResource(R.drawable.start);
                }
            }
        });

        //receiving user data
        UerAccount user = (UerAccount) getIntent().getSerializableExtra("user");
        Game bronze = (Game) getIntent().getSerializableExtra("game");
        HashSet<Integer> selection_key = (HashSet<Integer>) getIntent().getSerializableExtra("selection");
        int[] answer = bronze.answer;

        //Displaying right options
        ImageView shape1 = findViewById(R.id.answer1);
        shape1.setImageResource(bronze.shapes[answer[0]]);
        ImageView shape2 = findViewById(R.id.answer2);
        shape2.setImageResource(bronze.shapes[answer[1]]);
        ImageView shape3 = findViewById(R.id.answer3);
        shape3.setImageResource(bronze.shapes[answer[2]]);

        //showing right options and score gained
        TextView performance = (TextView) findViewById(R.id.pointsGain);
        int points_thisRound = 0;
        int num_right = 0;
        for (int i = 0; i < answer.length; i++) {
            Iterator iterator = selection_key.iterator();
            while (iterator.hasNext()){
                int selection = (int) iterator.next();
                if(selection == answer[i]){
                    num_right++;
                }
            }

        }


        if (num_right == 1) {
            points_thisRound = 20;
            performance.setText("   NOT BAD  \nGAIN 20 POINTS");
        } else if (num_right == 2) {
            points_thisRound = 60;
            performance.setText(" GOOD PERFORMANCE\nGAIN 60 POINTS");
        } else if (num_right == 3) {
            points_thisRound = 100;
            performance.setText("EXCELLENT PERFORMANCE\nGAIN 100 POINTS");
        } else {
            performance.setText(" BAD PERFORMANCE\nGAIN 0 POINT");
        }
        //update user's points
        user.updatePoints(points_thisRound);

        //setting exit button
        Button exitButton = (Button) findViewById(R.id.exitbutton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, AccountActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        //setting next round button
        Button nextRound = (Button) findViewById(R.id.nextRound);
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.gettotalPoints() >= 100){
                    Intent intent = new Intent(ResultActivity.this, GameLv2Activity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(ResultActivity.this, GameActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }

            }
        });


    }
}
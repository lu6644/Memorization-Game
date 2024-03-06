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
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AnswerActivity extends AppCompatActivity {


    private Chronometer timingCh;
    HashSet<Integer> selection_key = new HashSet<>();
    int num_selection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        //setting music
        final Intent serviceIntent = new Intent(AnswerActivity.this,MusicService.class);
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

        //setting time
        timingCh = (Chronometer) findViewById(R.id.timing);
        timingCh.setBase(SystemClock.elapsedRealtime());
        timingCh.setFormat("%s");
        timingCh.start();



        //receiving user and displaying score
        UerAccount user = (UerAccount) getIntent().getSerializableExtra("user");
        TextView scoreTextview = (TextView) findViewById(R.id.score);
        scoreTextview.setText("Your Score: \n" + "     " + user.gettotalPoints());

        //receiving game and displaying badge
        Game bronze = (Game) getIntent().getSerializableExtra("game");
        int[] shapes = bronze.shapes;


        //displaying options
        Object[] options = bronze.getOptions();
        int num1 = (int) options[0];
        int num2 = (int) options[1];
        int num3 = (int) options[2];
        int num4 = (int) options[3];
        int num5 = (int) options[4];
        int num6 = (int) options[5];
        ImageButton option1 = (ImageButton) findViewById(R.id.img1);
        option1.setImageResource(shapes[num1]);
        ImageButton option2 = (ImageButton) findViewById(R.id.img2);
        option2.setImageResource(shapes[num2]);
        ImageButton option3 = (ImageButton) findViewById(R.id.img3);
        option3.setImageResource(shapes[num3]);
        ImageButton option4 = (ImageButton) findViewById(R.id.img4);
        option4.setImageResource(shapes[num4]);
        ImageButton option5 = (ImageButton) findViewById(R.id.img5);
        option5.setImageResource(shapes[num5]);
        ImageButton option6 = (ImageButton) findViewById(R.id.img6);
        option6.setImageResource(shapes[num6]);


        //showing user's selections
        ImageView userSelection1 = (ImageView) findViewById(R.id.user_image1);
        ImageView userSelection2 = (ImageView) findViewById(R.id.user_image2);
        ImageView userSelection3 = (ImageView) findViewById(R.id.user_image3);


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key.add(num1);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num1]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num1]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num1]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key.add(num2);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num2]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num2]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num2]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key.add(num3);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num3]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num3]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num3]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key.add(num4);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num4]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num4]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num4]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key.add(num5);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num5]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num5]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num5]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        option6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key.add(num6);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num6]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num6]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num6]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //setting clear button to clear all user's selections
        Button clearButton = (Button)findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection1.setImageResource(R.drawable.empty);
                userSelection2.setImageResource(R.drawable.empty);
                userSelection3.setImageResource(R.drawable.empty);
                num_selection = 0;
                selection_key.clear();
            }
        });


        //setting done button
        Button doneButton = (Button)findViewById(R.id.done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnswerActivity.this, ResultActivity.class);
                intent.putExtra("selection",selection_key);
                intent.putExtra("user",user);
                intent.putExtra("game",bronze);
                timingCh.stop();
                startActivity(intent);
            }
        });



    }


}
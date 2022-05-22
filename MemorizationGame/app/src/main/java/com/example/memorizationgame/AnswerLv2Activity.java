package com.example.memorizationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

public class AnswerLv2Activity extends AppCompatActivity {

    private Chronometer timingCh;
    HashSet<Integer> selection_key = new HashSet<>();
    int num_selection = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_lv2);

        //setting music
        final Intent serviceIntent = new Intent(AnswerLv2Activity.this,MusicService.class);
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
        Object[] options = bronze.getOptionsLv2();
        int num1 = (int) options[0];
        int num2 = (int) options[1];
        int num3 = (int) options[2];
        int num4 = (int) options[3];
        int num5 = (int) options[4];
        int num6 = (int) options[5];
        int num7 = (int) options[6];
        int num8 = (int) options[7];
        int num9 = (int) options[8];
        int num10 = (int) options[9];
        int num11 = (int) options[10];
        int num12 = (int) options[11];
        ImageButton option1 = (ImageButton) findViewById(R.id.img1);
        option1.setImageResource(shapes[num1]);
        ImageButton option2 = (ImageButton) findViewById(R.id.img2);
        option2.setImageResource(shapes[num2]);
        ImageButton option3 = (ImageButton) findViewById(R.id.img3);
        option3.setImageResource(shapes[num3]);
        ImageButton option4 = (ImageButton) findViewById(R.id.img10);
        option4.setImageResource(shapes[num4]);
        ImageButton option5 = (ImageButton) findViewById(R.id.img5);
        option5.setImageResource(shapes[num5]);
        ImageButton option6 = (ImageButton) findViewById(R.id.img6);
        option6.setImageResource(shapes[num6]);
        ImageButton option7 = (ImageButton) findViewById(R.id.img);
        option7.setImageResource(shapes[num7]);
        ImageButton option8 = (ImageButton) findViewById(R.id.img9);
        option8.setImageResource(shapes[num8]);
        ImageButton option9 = (ImageButton) findViewById(R.id.img8);
        option9.setImageResource(shapes[num9]);
        ImageButton option10 = (ImageButton) findViewById(R.id.img13);
        option10.setImageResource(shapes[num10]);
        ImageButton option11 = (ImageButton) findViewById(R.id.img12);
        option11.setImageResource(shapes[num11]);
        ImageButton option12 = (ImageButton) findViewById(R.id.img11);
        option12.setImageResource(shapes[num12]);



        //showing user's selections
        ImageView userSelection1 = (ImageView) findViewById(R.id.user_image1);
        ImageView userSelection2 = (ImageView) findViewById(R.id.user_image2);
        ImageView userSelection3 = (ImageView) findViewById(R.id.user_image3);
        ImageView userSelection4 = (ImageView) findViewById(R.id.user_image4);
        ImageView userSelection5 = (ImageView) findViewById(R.id.user_image5);
        ImageView userSelection6 = (ImageView) findViewById(R.id.user_image6);


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num1);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num1]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num1]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num1]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num1]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num1]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num1]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num2);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num2]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num2]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num2]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num2]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num2]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num2]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num3);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num3]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num3]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num3]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num3]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num3]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num3]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num4);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num4]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num4]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num4]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num4]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num4]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num4]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num5);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num5]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num5]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num5]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num5]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num5]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num5]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num6);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num6]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num6]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num6]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num6]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num6]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num6]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num7);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num7]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num7]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num7]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num7]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num7]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num7]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num8);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num8]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num8]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num8]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num8]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num8]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num8]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num9);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num9]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num9]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num9]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num9]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num9]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num9]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num10);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num10]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num10]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num10]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num10]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num10]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num10]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        option11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num11);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num11]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num11]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num11]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num11]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num11]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num11]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        option12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 6){
                    selection_key.add(num12);
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num12]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num12]);
                        num_selection++;
                    }else if(num_selection == 2){
                        userSelection3.setImageResource(shapes[num12]);
                        num_selection++;
                    }else if(num_selection == 3){
                        userSelection4.setImageResource(shapes[num12]);
                        num_selection++;
                    }else if(num_selection == 4){
                        userSelection5.setImageResource(shapes[num12]);
                        num_selection++;
                    } else {
                        userSelection6.setImageResource(shapes[num12]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerLv2Activity.this, "You have already Selected Six shapes!", Toast.LENGTH_SHORT).show();
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
                userSelection4.setImageResource(R.drawable.empty);
                userSelection5.setImageResource(R.drawable.empty);
                userSelection6.setImageResource(R.drawable.empty);
                num_selection = 0;
                selection_key.clear();
            }
        });


        //setting done button
        Button doneButton = (Button)findViewById(R.id.done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnswerLv2Activity.this, ResultLv2Activity.class);
                intent.putExtra("selection",selection_key);
                intent.putExtra("user",user);
                intent.putExtra("game",bronze);
                //long time = SystemClock.elapsedRealtime();
                timingCh.stop();
                startActivity(intent);
            }
        });

    }
}
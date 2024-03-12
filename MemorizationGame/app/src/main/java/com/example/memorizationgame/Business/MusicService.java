package com.example.memorizationgame.Business;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.memorizationgame.R;

public class MusicService extends Service {
    public static boolean isplay;
    MediaPlayer player;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.music);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!player.isPlaying()){
            player.start();
            player.setLooping(true);
            isplay = player.isPlaying();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        isplay = player.isPlaying();
        player.release();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
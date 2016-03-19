package com.games.android.android_fortune.fortune;

import android.graphics.Color;
import android.util.Log;

import com.games.android.android_fortune.frame.Game;
import com.games.android.android_fortune.frame.Graphics;
import com.games.android.android_fortune.frame.Screen;

/**
 * Created by sanins.inshink on 2016/02/25.
 */
public class MainMenuScreen extends Screen {

    private int flg = 0;
    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Log.println(Log.ASSERT,"MainMenuScreen :","↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓開始(present)↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");

        Log.println(Log.ASSERT,"MainMenuScreen :",String.valueOf(game.getGraphics()));
        Log.println(Log.ASSERT,"MainMenuScreen :",String.valueOf(Assets.background));

        Graphics g = game.getGraphics();
        if(flg == 0){
            g.clear(Color.WHITE);
            g.drawPixMap(Assets.background, 0, 0);
            g.drawLine(0, 416, 480, 416, Color.WHITE);
            flg = 1;
        }else if(flg == 1){
            g.clear(Color.WHITE);
            g.drawPixMap(Assets.logo, 0, 0);
            g.drawLine(0, 416, 480, 416, Color.WHITE);
            flg = 2;
        }else{
            g.clear(Color.BLACK);
            flg = 0;
        }
        Log.println(Log.ASSERT,"MainMenuScreen ","↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑終了(present)↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");

    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}

package com.games.android.android_fortune.canvas.screen;

import android.graphics.Color;
import android.util.Log;

import com.games.android.android_fortune.common.game.Game;
import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.common.graphic.Graphics;
import com.games.android.android_fortune.common.input.Input;
import com.games.android.android_fortune.common.loading.Assets;


/**
 * Created by sanins.inshink on 2016/02/25.
 */
public class StartScreen extends Screen {

    private int flg = 0;
    public StartScreen(Game game) {
        super(game);
    }
    private int count = 0;

    @Override
    public void update(float deltaTime) {
        Log.println(Log.ASSERT,"MainMenuScreen :","↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓開始(present)↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        Input in = game.getInput();
        //Log.println(Log.ASSERT,"MainMenuScreen :",String.valueOf(in.getTouchEvents().toString()));


        Graphics g = game.getGraphics();
        if(flg == 0){
            g.clear(Color.WHITE);
            g.drawPixMap(Assets.koma1, 0, count);
            g.drawLine(0, 416, 480, 416, Color.WHITE);
            flg = 1;
        }else{
            count ++;
            flg = 0;
        }
        if(150 <= count){
            game.moveActivity();
        }

    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixMap(Assets.start,100,100);

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

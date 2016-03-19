package com.games.android.android_fortune.canvas.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;

import com.games.android.android_fortune.common.game.Game;
import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.common.graphic.GraphicsImpl;
import com.games.android.android_fortune.common.graphic.Graphics;
import com.games.android.android_fortune.common.input.Input;
import com.games.android.android_fortune.common.input.InputImpl;
import com.games.android.android_fortune.common.start.AndroidStartProgramGL;


public abstract class FortuneGame extends Activity implements Game {

    FortuneView view;
    Graphics graphics;
    Input input;
    Screen screen;

    @Override
    public void onCreate(Bundle savedInstanceState){
        Log.println(Log.ASSERT,"FortuneGame :","↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓開始(onCreate)↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");

        super.onCreate(savedInstanceState);
        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        Log.println(Log.ASSERT,"isLandscape : ",String.valueOf(isLandscape));


        // ディスプレイのインスタンス生成・幅・大きさの取得
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        Log.println(Log.ASSERT,"Width : ",String.valueOf(size.x));
        Log.println(Log.ASSERT,"Height : ",String.valueOf(size.y));

        //frameBufferの設定
        int frameBufferWidth = isLandscape ? 480 : 320;
        int frameBufferHeight = isLandscape ? 320 : 480;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth ,
                frameBufferHeight, Bitmap.Config.RGB_565);

        //View・Graphics・Screenの初期化を行う
        view = new FortuneView(this,frameBuffer);
        graphics = new GraphicsImpl(getAssets(),frameBuffer);
        input = new InputImpl(this,view,frameBufferWidth,frameBufferHeight);
        screen = getStartScreen();

        Log.println(Log.ASSERT,"FortuneGame ",String.valueOf(getStartScreen()));
        setContentView(view);
        Log.println(Log.ASSERT,"FortuneGame ","↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑終了(onCreate)↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    @Override
    public void onResume(){
        super.onResume();
        view.resume();
    }
    @Override
    public void onPause(){
        super.onPause();
        view.pause();
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public void moveActivity() {
        Intent intent = new Intent(getApplication(), AndroidStartProgramGL.class);
        startActivity(intent);
    }

    @Override
    public void setScreen(Screen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");
        this.screen = screen;
    }
    @Override
    public Screen getCurrentScreen() {
        return screen;
    }

}

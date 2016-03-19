package com.games.android.android_fortune.impl;

import android.app.*;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.*;
import android.util.*;
import android.view.Display;
import android.view.WindowManager;

import com.games.android.android_fortune.frame.Game;
import com.games.android.android_fortune.frame.Graphics;
import com.games.android.android_fortune.frame.Screen;


public abstract class FortuneMainGame extends Activity implements Game {

    FortuneMainView view;
    FortuneMainGraphics graphics;
    Screen screen;

    @Override
    public void onCreate(Bundle savedInstanceState){
        Log.println(Log.ASSERT,"FortuneMainGame :","↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓開始(onCreate)↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");

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
        view = new FortuneMainView(this,frameBuffer);
        graphics = new FortuneMainGraphics(getAssets(),frameBuffer);
        screen = getStartScreen();

        Log.println(Log.ASSERT,"FortuneMainGame ",String.valueOf(getStartScreen()));
        setContentView(view);
        Log.println(Log.ASSERT,"FortuneMainGame ","↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑終了(onCreate)↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
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

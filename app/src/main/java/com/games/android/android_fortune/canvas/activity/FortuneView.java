package com.games.android.android_fortune.canvas.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.*;
import android.view.*;

import com.games.android.android_fortune.canvas.activity.FortuneGame;

/**
 *  アンドロイドの画面表示を担当するクラス。
 *  アプリが起動中の場合、このクラスのスレッドから、
 *  各種処理が実行される。
 */

public class FortuneView extends SurfaceView implements Runnable{
    FortuneGame game;
    Bitmap framebuffer;
    Thread renderThread = null;
    SurfaceHolder holder;
    volatile boolean running = false;

    /** コンストラクタ */
    public FortuneView(FortuneGame game, Bitmap framebuffer){
        super(game);
        this.game = game;
        this.framebuffer = framebuffer;
        this.holder = getHolder();
    }

    public void resume() {
        running = true;
        renderThread = new Thread(this);
        renderThread.start();
    }

    @Override
    public void run() {
        Log.println(Log.ASSERT,"FortuneMainView :","↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓開始(run)↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");

        Rect dstRect = new Rect();
        long startTime = System.nanoTime();

        /** スレッド実行中 */
        while(running) {
            /** Canvasエラーで加えたもの */
            if(!holder.getSurface().isValid())
                continue;


            /** このスレッド内にて、経過時間の取得 */
            float deltaTime = (System.nanoTime()-startTime) / 1000000000.0f;
            startTime = System.nanoTime();

            game.getCurrentScreen().update(deltaTime);
            game.getCurrentScreen().present(deltaTime);


            /** Canvasエラーで加えたもの */

            Canvas canvas = holder.lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(framebuffer, null, dstRect, null);
            holder.unlockCanvasAndPost(canvas);

            //Log.println(Log.ASSERT,"game " , String.valueOf(game == null));
            //Log.println(Log.ASSERT,"getCurrentScreen() " , String.valueOf(game.getCurrentScreen()));

            //game.getCurrentScreen().present(deltaTime);
            //Log.println(Log.ASSERT,"runningの値" , "running="+running);
        }
    }

    public void pause() {
        running = false;
    }

}

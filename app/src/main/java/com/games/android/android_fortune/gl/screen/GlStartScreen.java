package com.games.android.android_fortune.gl.screen;

import android.util.Log;

import com.games.android.android_fortune.common.game.GLScreen;
import com.games.android.android_fortune.common.game.Game;
import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.common.input.Input;
import com.games.android.android_fortune.common.input.Input.TouchEvent;
import com.games.android.android_fortune.gl.activity.GlGame;

import java.util.List;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

/**
 * Gl系の画面を描画する際のスタート画面
 */
public class GlStartScreen extends GLScreen {

    public GlStartScreen(Game game) {
        super(game);
    }

    @Override
    /**スタート画面における画面の描画を更新する */
    public void update(float deltaTime) {
        //描画画面におけるユーザーのインプットを取得する
        Input in = game.getInput();

        Log.println(Log.ASSERT,"Input ",String.valueOf(in));
        Log.println(Log.ASSERT,"in.getTouchEvents() ",String.valueOf(in.getTouchEvents()));
        List<TouchEvent> event = in.getTouchEvents();

        if(event != null){
            Log.println(Log.ASSERT,"getTouchEvents Size ",String.valueOf(event.size()));
        }

        Random rand = new Random();
        Log.println(Log.ASSERT,"glGraphics : ",String.valueOf(glGraphics));
        Log.println(Log.ASSERT,"getGl() : ",String.valueOf(glGraphics.getGl()));

        GL10 gl = glGraphics.getGl();

        gl.glClearColor(rand.nextFloat(), rand.nextFloat(),
                rand.nextFloat(), 2);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

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

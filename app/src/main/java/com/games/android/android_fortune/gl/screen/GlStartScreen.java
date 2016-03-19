package com.games.android.android_fortune.gl.screen;

import android.util.Log;

import com.games.android.android_fortune.common.game.GLScreen;
import com.games.android.android_fortune.common.game.Game;
import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.gl.activity.GlGame;

import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by sanins.inshink on 2016/03/12.
 */
public class GlStartScreen extends GLScreen {

    public GlStartScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Log.println(Log.ASSERT,"AndroidStartProgramGL ","getStartScreen : 開始");
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

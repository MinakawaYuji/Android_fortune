package com.games.android.android_fortune.fortune;

import android.util.Log;

import com.games.android.android_fortune.frame.Game;
import com.games.android.android_fortune.frame.Graphics;
import com.games.android.android_fortune.frame.Graphics.PixMapFormat;
import com.games.android.android_fortune.frame.Screen;

/**
 * Created by sanins.inshink on 2016/02/23.
 */
public class LoadingScreen extends Screen {

    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
        public void update(float deltaTime) {
        Log.println(Log.ASSERT,"LoadingScreen : "+deltaTime," ");
        Graphics g = game.getGraphics();
        Assets.background = g.newPixMap("background.png", PixMapFormat.RGB565);
        Assets.logo = g.newPixMap("logo.png", PixMapFormat.ARGB4444);
        game.setScreen(new MainMenuScreen(game));
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

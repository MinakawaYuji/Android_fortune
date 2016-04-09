package com.games.android.android_fortune.common.loading;

import android.util.Log;

import com.games.android.android_fortune.canvas.screen.StartScreen;
import com.games.android.android_fortune.common.game.Game;
import com.games.android.android_fortune.common.graphic.Graphics;
import com.games.android.android_fortune.common.graphic.Graphics.PixMapFormat;
import com.games.android.android_fortune.common.game.Screen;

/**
 * 最初のローディングで呼び出されるアセット読込用クラス
 * 画面で読み込むアセットを読み込む.
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
        Assets.koma1 = g.newPixMap("Koma1.PNG", PixMapFormat.ARGB4444);
        Assets.start = g.newPixMap("start.PNG",PixMapFormat.ARGB4444);

        game.setScreen(new StartScreen(game));
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

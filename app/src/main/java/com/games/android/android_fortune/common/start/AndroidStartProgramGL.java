package com.games.android.android_fortune.common.start;

import android.app.Activity;
import android.util.Log;

import com.games.android.android_fortune.common.file.FileIO;
import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.gl.activity.GlGame;
import com.games.android.android_fortune.gl.screen.GlStartScreen;

/**
 *  アンドロイドが起動した際に、onCreateから最初にアクセスするクラス（Open GL画面において）。
 *  このクラスから次のスクリーンに遷移する、(LoadingScreen)
 */
public class AndroidStartProgramGL extends GlGame{

    @Override
    public FileIO getFileIO() {
        return null;
    }

    @Override
    public Screen getStartScreen() {
        return new GlStartScreen(this);
    }
}

package com.games.android.android_fortune.common.start;


import android.util.Log;

import com.games.android.android_fortune.common.loading.LoadingScreen;
import com.games.android.android_fortune.canvas.activity.FortuneGame;
import com.games.android.android_fortune.common.game.Screen;

/**
 *  アンドロイドが起動した際に、onCreateから最初にアクセスするクラス（画面関連において）。
 *  このクラスから次のスクリーンに遷移する、(LoadingScreen)
 */

public class AndroidStartProgramCanvas extends FortuneGame {

    @Override
    public Screen getStartScreen() {
        Log.println(Log.ASSERT,"CanvasStart  "," ");
        return new LoadingScreen(this);
    }
}

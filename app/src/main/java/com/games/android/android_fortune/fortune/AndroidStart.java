package com.games.android.android_fortune.fortune;


import android.util.Log;

import com.games.android.android_fortune.impl.FortuneMainGame;
import com.games.android.android_fortune.frame.Screen;

/**
 *  アンドロイドが起動した際に、onCreateから最初にアクセスするクラス（画面関連において）。
 *  このクラスから次のスクリーンに遷移する、(LoadingScreen)
 */

public class AndroidStart extends FortuneMainGame {

    @Override
    public Screen getStartScreen() {
        Log.println(Log.ASSERT,"AndroidStart  "," ");
        return new LoadingScreen(this);
    }
}

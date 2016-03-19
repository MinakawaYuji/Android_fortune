package com.games.android.android_fortune.common.start;

import android.app.Activity;
import android.util.Log;

import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.gl.activity.GlGame;
import com.games.android.android_fortune.gl.screen.GlStartScreen;

/**
 * Created by sanins.inshink on 2016/03/11.
 */
public class AndroidStartProgramGL extends GlGame{

    @Override
    public Screen getStartScreen() {
        return new GlStartScreen(this);
    }
}

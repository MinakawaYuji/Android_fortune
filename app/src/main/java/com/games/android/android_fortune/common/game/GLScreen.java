package com.games.android.android_fortune.common.game;

import com.games.android.android_fortune.common.graphic.GlGraphics;
import com.games.android.android_fortune.gl.activity.GlGame;

public abstract class GLScreen extends Screen {
    protected final GlGraphics glGraphics;
    protected final GlGame glGame;
    
    public GLScreen(Game game) {
        super(game);
        glGame = (GlGame)game;
        glGraphics = ((GlGame)game).getGLGraphics();
    }

}

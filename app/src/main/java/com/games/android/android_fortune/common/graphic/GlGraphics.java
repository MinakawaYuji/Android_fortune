package com.games.android.android_fortune.common.graphic;

import javax.microedition.khronos.opengles.GL10;

/**
 * Glのグラフィック処理を担当する
 */
public interface GlGraphics {

    public void setGl(GL10 gl);

    public GL10 getGl();

}

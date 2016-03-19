package com.games.android.android_fortune.common.graphic;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by sanins.inshink on 2016/03/12.
 */
public class GlGraphicsImpl implements GlGraphics{

    /**コンストラクタ */
    private GL10 gl ;
    /** glの幅を設定 */
    private int width;
    /** glの幅を設定 */
    private int height;

    /**コンストラクタ */
    public GlGraphicsImpl(GLSurfaceView glView){
        setWidth(glView.getWidth());
        setHeight(glView.getHeight());
    }

    /**GLコンフィグのセット */
    @Override
    public void setGl(GL10 gl) {
        this.gl = gl;
    }

    /**GLコンフィグの取得*/
    @Override
    public GL10 getGl() {
        return gl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

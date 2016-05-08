package com.games.android.android_fortune.gl.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.games.android.android_fortune.common.file.FileIO;
import com.games.android.android_fortune.common.file.FileIOImpl;
import com.games.android.android_fortune.common.game.Game;
import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.common.graphic.GlGraphics;
import com.games.android.android_fortune.common.graphic.GlGraphicsImpl;
import com.games.android.android_fortune.common.graphic.Graphics;
import com.games.android.android_fortune.common.graphic.GraphicsImpl;
import com.games.android.android_fortune.common.input.Input;
import com.games.android.android_fortune.common.input.InputImpl;

import java.io.File;

/**
 * アクティビティーの制御を行うクラス
 */
public abstract class GlGame extends Activity implements Game{

    /** Glを描画する為のビュー */
    GLSurfaceView glView;
    /** グラフィック */
    Graphics graphics;
    /** Gl設定項目を取得する為のインスタンス */
    GlGraphics glGraphics;
    /** 描画画面のイベントを取得する */
    Input input;
    /** 描画画面のイベントを取得する */
    FileIO file;
    /** 画面を出力する為のクラス */
    Screen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** レンダリングするビューの設定 */
        glView = new GLSurfaceView(this);
        glView.setRenderer(new GlView(this));
        setContentView(glView);

        /** 初期化項目の設定 */
        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandscape ? 480 : 320;
        int frameBufferHeight = isLandscape ? 320 : 480;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
                frameBufferHeight, Bitmap.Config.RGB_565);
        graphics = new GraphicsImpl(getAssets(),frameBuffer);
        glGraphics = new GlGraphicsImpl(glView);
        file = new FileIOImpl(getAssets());
        input = new InputImpl(this,glView,300,480);
        screen = getStartScreen();
    }

    /** Glの状態を返却 */
    public GlGraphics getGLGraphics() {
        return glGraphics;
    }

    /** グラフィックの返却 */
    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public void moveActivity() {

    }
    @Override
    public Screen getCurrentScreen() {
        return screen;
    }

    @Override
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

}

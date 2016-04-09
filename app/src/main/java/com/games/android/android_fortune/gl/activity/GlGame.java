package com.games.android.android_fortune.gl.activity;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.games.android.android_fortune.common.game.Game;
import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.common.graphic.GlGraphics;
import com.games.android.android_fortune.common.graphic.GlGraphicsImpl;
import com.games.android.android_fortune.common.graphic.Graphics;
import com.games.android.android_fortune.common.input.Input;
import com.games.android.android_fortune.common.input.InputImpl;

/**
 * アクティビティーの制御を行うクラス
 */
public abstract class GlGame extends Activity implements Game{

    /** Glを描画する為のビュー */
    GLSurfaceView glView;
    /** Gl設定項目を取得する為のインスタンス */
    GlGraphics glGraphics;
    /** 描画画面のイベントを取得する */
    Input input;
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
        glGraphics = new GlGraphicsImpl(glView);
        input = new InputImpl(this,glView,300,480);
        screen = getStartScreen();
    }

    /** Glの状態を返却 */
    public GlGraphics getGLGraphics() {
        return glGraphics;
    }

    @Override
    public Graphics getGraphics() {
        return null;
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

package com.games.android.android_fortune.gl.activity;

import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * 画面描画の制御を行う。
 * 位置付け的にはControllerに相当
 */
public class GlView implements GLSurfaceView.Renderer {

    /**ゲーム状態を表すENUM */
    enum GLGameState {
        Initialized,
        Running,
        Paused,
        Finished,
        Idle
    }

    /**ゲーム状態初期化 */
    GLGameState state = GLGameState.Initialized;
    /**GlGameのインスタンス */
    GlGame glgame;
    /**スレッド管理用オブジェクト */
    Object stateChanged = new Object();
    /**ゲーム時間のデルタタイム計算用 */
    long startTime = System.nanoTime();

    /**コンストラクタ */
    public GlView(GlGame glgame){
        this.glgame = glgame;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        glgame.getGLGraphics().setGl(gl);

        Log.println(Log.ASSERT,"onSurfaceCreated : ",String.valueOf("start"));
        Log.println(Log.ASSERT,"onSurfaceCreated : ",String.valueOf(" "));
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Log.println(Log.ASSERT,"onSurfaceChanged : ",String.valueOf("start"));
        Log.println(Log.ASSERT,"onSurfaceChanged : ",String.valueOf(" "));
    }

    @Override
    public void onDrawFrame(GL10 gl){
        float deltaTime = (System.nanoTime()-startTime) / 1000000000.0f;

        Log.println(Log.ASSERT,"onDrawFrame : ",String.valueOf("start"));
        Log.println(Log.ASSERT,"onDrawFrame : ",String.valueOf(" "));
        Log.println(Log.ASSERT,"glgame : ",String.valueOf(glgame));
        Log.println(Log.ASSERT,"ggetCurrentScreen() : ",String.valueOf(glgame.getCurrentScreen()));
        glgame.getCurrentScreen().update(deltaTime);
    }

}

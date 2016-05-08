package com.games.android.android_fortune.gl.screen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import android.util.Log;

import com.games.android.android_fortune.common.game.GLScreen;
import com.games.android.android_fortune.common.game.Game;
import com.games.android.android_fortune.common.game.Screen;
import com.games.android.android_fortune.common.graphic.GlGraphicsImpl;
import com.games.android.android_fortune.common.graphic.Graphics;
import com.games.android.android_fortune.common.input.Input;
import com.games.android.android_fortune.common.input.Input.TouchEvent;
import com.games.android.android_fortune.common.loading.Assets;
import com.games.android.android_fortune.gl.activity.GlGame;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;
import com.games.android.android_fortune.common.graphic.GlGraphics;
/**
 * Gl系の画面を描画する際のスタート画面
 */
public class GlStartScreen extends GLScreen {


    /** ゲーム状態を監視するEnum */
    enum GlStartScreenState{
        Initialized
    }

    /**ゲーム状態初期化 */
    GlStartScreenState state = GlStartScreenState.Initialized;

    /** グラフィックに関するインスタンス */
    Graphics graphics;

    /** GLグラフィックに関するインスタンス */
    GlGraphicsImpl glGraphics;

    /** グラフィック描画する為のバッファ */
    FloatBuffer vertices;



    /** コンストラクタ */
    public GlStartScreen(GlGame game) {
        super(game);
        this.graphics   = game.getGraphics();
        this.glGraphics = (GlGraphicsImpl) game.getGLGraphics();

        //ネイティブのヒープメモリに引数(3 * 2 * 4)分の割り当てを行い・CPUのバイトオーダーで方式の設定
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(3 * 2 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());

        //byte形式からFloat形式に変換、Floatは4byteを消費する為、24(3 * 2 * 4) / 4 = 6個分の配列が割り当てられる
        //計算式は3つの頂点にx,yの座標がfloatで占めるバイト数を指定する
        vertices = byteBuffer.asFloatBuffer();

    }

    public int loadTexture(String fileName) {
        try {
            //ビットマップの読み込み
            Bitmap bitmap = BitmapFactory.decodeStream(game.getFileIO().readAsset(fileName));
            GL10 gl = glGraphics.getGl();
            int textureIds[] = new int[1];

            /** glGenTextures */
            //glGenTextures
            //        (
            //         int    n,        → 作成したいテキスチャーオブジェクトの数
            //         int[]  textures, → OpenGL ESが作成したテキスチャーオブジェクトのIDを書き込むInt型の配列
            //         int    offset,   → この配列においてIDの書き込みを開始する場所
            //        )
            // テキスチャーオブジェクトを作成する
            gl.glGenTextures(1, textureIds, 0);
            int textureId = textureIds[0];

            /** glBindTexture */
            //glBindTexture
            //        (
            //         int    target,   → バインドするテクスチャの種類を指定する
            //         int    texture   → テクスチャーのID
            //        )
            // 作成したテキスチャーオブジェクトと読込んだテキスチャーオブジェクトをバインディングさせる。
            gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);

            /** GLUtils.texImage2D */
            //GLUtils.texImage2D
            //        (
            //         int     target,  → テキスチャーの種類
            //         int     level,   → ミップマッピングレベル
            //         Bitmap  bitmap,  → 読込むビットマップ
            //         int     border   → いかなる時も0
            //        )
            // バインディングしたテキスチャーオブジェクトと画像データを関連させる。
            GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);

            /** glTexParameterf */
            //glTexParameterf
            //        (
            //         int     target,  → テキスチャーの種類
            //         int     pname,   → 設定対象となる属性.縮小(GL10.GL_TEXTURE_MIN_FILTER) , 拡大(GL10.GL_TEXTURE_MAG_FILTER)
            //         int     float    → フィルタの種類、GL10.GL_NEAREST . GL10.GL_LINEAR
            //        )
            // スクリーン上で使うピクセルの方がテキスチャーマップから取り出したピクセルよりも少ない時、多い時、テキスチャーを縮小または拡大させる。
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_NEAREST);

            //テクスチャオブジェクトの定義完了後、不要になったビットマップを解法する
            gl.glBindTexture(GL10.GL_TEXTURE_2D, 0);
            bitmap.recycle();
            return textureId;
        } catch(IOException e) {
            Log.d("TexturedTriangleTest", "couldn't load asset 'bobrgb888.png'!");
            throw new RuntimeException("couldn't load asset '" + fileName + "'");
        }
    }


    @Override
    /** スタート画面における画面の描画を更新する */
    public void update(float deltaTime) {


        /** 実装やる事リスト */
        /** 1. Startボタンを設置する */
        /** 2. Touchイベントを認識させる */
        /** 3. ViewPortを変更する処理を追加する */
        /** 4. タッチした場所に花火を作る */


        /** Inputのインスタンスを取得する */
        Input in = game.getInput();



        Log.println(Log.ASSERT,"Input ",String.valueOf(in));
        Log.println(Log.ASSERT,"in.getTouchEvents() ",String.valueOf(in.getTouchEvents()));
        List<TouchEvent> event = in.getTouchEvents();


        if(event != null){
            Log.println(Log.ASSERT,"getTouchEvents Size ",String.valueOf(event.size()));
        }

        Random rand = new Random();
        Log.println(Log.ASSERT,"glGraphics : ",String.valueOf(glGraphics));
        Log.println(Log.ASSERT,"getGl() : ",String.valueOf(glGraphics.getGl()));

        GL10 gl = glGraphics.getGl();

//        gl.glClearColor(rand.nextFloat(), rand.nextFloat(),
//                rand.nextFloat(), 2);
        gl.glClearColor(1,1,1,1);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void present(float deltaTime) {


        /** glの取得 */
        GL10 gl = glGraphics.getGl();

        /** glViewport */
        //glViewport
        //      (
        //        int x,
        //        int y,
        //        int width,
        //        int height
        //       )
        //x,yは左上角を定義して、widthとheightを指定する
        gl.glViewport(0, 0, glGraphics.getWidth(), glGraphics.getHeight());
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}

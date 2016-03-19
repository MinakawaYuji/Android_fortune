package com.games.android.android_fortune.common.graphic;

import android.graphics.Bitmap;

import com.games.android.android_fortune.common.graphic.Graphics;
import com.games.android.android_fortune.common.graphic.PixMap;

public class PixMapImpl implements PixMap {
    Bitmap bitmap;
    Graphics.PixMapFormat format;
    
    public PixMapImpl(Bitmap bitmap, Graphics.PixMapFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Graphics.PixMapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }      
}

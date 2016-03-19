package com.games.android.android_fortune.impl;

import android.graphics.Bitmap;

import com.games.android.android_fortune.frame.Graphics.PixMapFormat;
import com.games.android.android_fortune.frame.PixMap;

public class AndroidPixMap implements PixMap {
    Bitmap bitmap;
    PixMapFormat format;
    
    public AndroidPixMap(Bitmap bitmap, PixMapFormat format) {
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
    public PixMapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }      
}

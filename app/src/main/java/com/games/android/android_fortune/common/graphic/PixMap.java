package com.games.android.android_fortune.common.graphic;


import com.games.android.android_fortune.common.graphic.Graphics.PixMapFormat;

public interface PixMap {
    public int getWidth();

    public int getHeight();

    public PixMapFormat getFormat();

    public void dispose();
}

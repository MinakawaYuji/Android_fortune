package com.games.android.android_fortune.common.game;

import com.games.android.android_fortune.common.graphic.Graphics;
import com.games.android.android_fortune.common.input.Input;

public interface Game {
    public Input getInput();

    //public FileIO getFileIO();

    public Graphics getGraphics();

    //public Audio getAudio();

    public void moveActivity();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getStartScreen();
}
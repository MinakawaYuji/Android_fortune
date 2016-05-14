package com.games.android.android_fortune.common.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * File操作に関するインターフェイス.
 */
public interface FileIO {
    public InputStream readAsset(String fileName) throws IOException;

    public InputStream readFile(String fileName) throws IOException;

    public OutputStream writeFile(String fileName) throws IOException;

}

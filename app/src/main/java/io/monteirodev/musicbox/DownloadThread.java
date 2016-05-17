package io.monteirodev.musicbox;

import android.os.Looper;
import android.util.Log;


public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();
    public DownloadHandler mHandler;

    @Override
    public void run() {
//        // super.run();
//        // downloading one song at a time instead of all at once
//        for (String song : Playlist.songs) {
//            downloadSong();
//        }

        // Creates looper and message queue
        Looper.prepare();

        // associated by default with looper from current thread
        mHandler = new DownloadHandler();
        Looper.loop();
    }


}

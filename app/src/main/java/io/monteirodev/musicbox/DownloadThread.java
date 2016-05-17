package io.monteirodev.musicbox;

import android.util.Log;


public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();

    @Override
    public void run() {
        // super.run();
        // downloading one song at a time instead of all at once
        for (String song : Playlist.songs) {
            downloadSong();
        }
    }

    private void downloadSong() {
        // simulating download song from internet
        // for this project were going to simulate a 10sec download
        long endTime = System.currentTimeMillis() + 10*1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000); // avoid run on every millisecond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "Song downloaded!");
    }
}

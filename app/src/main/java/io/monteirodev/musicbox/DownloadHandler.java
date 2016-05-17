package io.monteirodev.musicbox;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class DownloadHandler extends Handler {
    private static final String TAG = DownloadHandler.class.getSimpleName();
    private DownloadService mService;

    @Override
    public void handleMessage(Message msg) {
        //super.handleMessage(msg);
        downloadSong(msg.obj.toString());

        // stopSelf would completly stop the DownloadService if no id is defined
        mService.stopSelf(msg.arg1);
    }

    private void downloadSong(String song) {
        // simulating download song from internet
        // for this project were going to simulate a 10sec download
        long endTime = System.currentTimeMillis() + 5*1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000); // avoid run on every millisecond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, song + " downloaded!");
    }

    public void setService(DownloadService service) {
        mService = service;
    }
}

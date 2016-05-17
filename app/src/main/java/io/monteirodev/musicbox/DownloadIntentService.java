package io.monteirodev.musicbox;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
/** replaces downloadService, downloadThread, downloadHandler
 * Used when we want to handle intents one at a time on separate Thread */
public class DownloadIntentService extends IntentService {
    private static final String TAG = DownloadIntentService.class.getSimpleName();

    public DownloadIntentService() {
        super("DownloadIntenService");
        // default is start_sticky but we need redelivery
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        downloadSong(song);
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
}

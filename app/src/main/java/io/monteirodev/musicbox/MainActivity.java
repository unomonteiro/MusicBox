package io.monteirodev.musicbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String KEY_SONG = "song";
    private Button mDownloadButton;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thread
        /*final DownloadThread thread = new DownloadThread();
        thread.setName("DownloadThread");
        thread.start();*/

        mDownloadButton = (Button) findViewById(R.id.downloadButton);
        mPlayButton = (Button) findViewById(R.id.playButton);

        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();

                // Thread
                /*// send Messages to Handler for processing
                for (String song : Playlist.songs) {
                    // android os keeps a pool of reusable messages
                    Message message = Message.obtain();
                    message.obj = song; // accepts any object
                    thread.mHandler.sendMessage(message);
                }*/

                // starting a service =~ activity
                for (String song : Playlist.songs) {
                    //Intent intent = new Intent(MainActivity.this, DownloadService.class);
                    Intent intent = new Intent(MainActivity.this, DownloadIntentService.class);
                    intent.putExtra(KEY_SONG, song);
                    startService(intent);
                }
            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}

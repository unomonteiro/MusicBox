package io.monteirodev.musicbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mDownloadbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownloadbutton = (Button) findViewById(R.id.downloadButton);

        mDownloadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();
                downloadSong();
            }
        });
    }

    private void downloadSong() {
        // todo download song from internet
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

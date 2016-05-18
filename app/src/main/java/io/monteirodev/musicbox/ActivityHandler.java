package io.monteirodev.musicbox;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

public class ActivityHandler extends Handler {
    private MainActivity mMainActivity;

    public ActivityHandler(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg.arg1 == 0){
            // Music is NOT playing
            if (msg.arg2 == 1){
                // update label only
                mMainActivity.changedPlayButtonText("Play");
            } else {
                // Play the music
                Message message = Message.obtain();
                message.arg1 = 0;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                // change play Button to say "Pause"
                mMainActivity.changedPlayButtonText("Pause");
            }
        } else if (msg.arg1 == 1){
            // Music IS playing
            if (msg.arg2 == 1){
                mMainActivity.changedPlayButtonText("Pause");
            } else {
                // Pause the music
                Message message = Message.obtain();
                message.arg1 = 1;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                // change play Button to say "Play"
                mMainActivity.changedPlayButtonText("Play");
            }
        }
    }
}

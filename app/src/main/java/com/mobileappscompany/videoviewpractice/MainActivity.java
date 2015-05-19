package com.mobileappscompany.videoviewpractice;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    @InjectView(R.id.videoView)VideoView videoView;
    MediaController vidControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        vidControl = new MediaController(this);
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.d("video", "setOnErrorListener ");
                return true;
            }
        });

        String vidAddress = getString(R.string.video_url);
        Uri vidUri = Uri.parse(vidAddress);
        videoView.setVideoURI(vidUri);
        videoView.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

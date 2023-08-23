package com.example.robbiewilliamsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.example.robbiewilliamsapp.models.ClientCredo;
import com.example.robbiewilliamsapp.tools.SpotifyAppRemoteClient;
import com.example.robbiewilliamsapp.tools.SpotifyAuthentication;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable tokenGenerationRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar); //TODO replayce after 1 hour

        SpotifyAuthentication.generateToken(); //
//        tokenGenerationRunnable = new Runnable() {
//            @Override
//            public void run() {
//                SpotifyAuthentication.generateToken();
//                handler.postDelayed(this, 3600000);
//            }
//        };
//
//        handler.postDelayed(tokenGenerationRunnable, 3600000);



        loadFragment(new WelcomeFragment());
    }


    @Override
    protected void onStart() {
        super.onStart();

        // prepare connectionParams for spotify remote app connection
        ConnectionParams connectionParams =
                new ConnectionParams.Builder(ClientCredo.getInstance().CLIENT_ID)
                        .setRedirectUri(ClientCredo.getInstance().REDIRECT_URI)
                        .showAuthView(true)
                        .build();

        // connect to spotify remote app
        SpotifyAppRemote.connect(this, connectionParams,
                new Connector.ConnectionListener() {

                    @Override
                    public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                        SpotifyAppRemoteClient.getInstance().setSpotifyAppRemote(spotifyAppRemote);
                        Log.d("MainActivity", "Connected to remote spotify app!");
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.e("MainActivity", throwable.getMessage(), throwable);
                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(SpotifyAppRemoteClient.getInstance().isPlaying()){
            SpotifyAppRemoteClient.getInstance().stop();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_item){
            loadFragment(new MainFragment());
        }else if(item.getItemId() == R.id.works_item){
            loadFragment(new MusicFragment());
        }else if(item.getItemId() == R.id.about_item){
            loadFragment(new AboutFragment());
        }
        return super.onOptionsItemSelected(item);
    }


    void loadFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_main, fragment);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(tokenGenerationRunnable);
    }
}



///https://api.spotify.com/v1/artists/2HcwFjNelS49kFbfvMxQYw artist
// https://api.spotify.com/v1/artists/2HcwFjNelS49kFbfvMxQYw/top-tracks?market=es music


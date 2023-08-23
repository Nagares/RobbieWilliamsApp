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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.robbiewilliamsapp.tools.SpotifyAuthentication;

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
        Button button = findViewById(R.id.button);

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


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SpotifyAuthentication.generateToken();
//            }
//        });

//        loadFragment(new MainFragment());
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


package com.example.robbiewilliamsapp.tools;

import android.widget.ImageButton;

import com.example.robbiewilliamsapp.R;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import java.util.ArrayList;
import java.util.List;

public class SpotifyAppRemoteClient {
    private static SpotifyAppRemoteClient instance;
    private SpotifyAppRemote spotifyAppRemote;
    private String currentTrackUri;
    private String currentTitle;
    private boolean isPlaying = false;
    private List<ImageButton> imageButtons = new ArrayList<>();

    private SpotifyAppRemoteClient() {
    }

    // Public method to get the singleton instance
    public static SpotifyAppRemoteClient getInstance() {
        if (instance == null) {
            synchronized (SpotifyAppRemoteClient.class) {
                if (instance == null) {
                    instance = new SpotifyAppRemoteClient();
                }
            }
        }
        return instance;
    }

    public void setSpotifyAppRemote(SpotifyAppRemote spotifyAppRemote) {
        this.spotifyAppRemote = spotifyAppRemote;
    }

    public void play(String trackUri, String currentTitle) {
        this.currentTitle = currentTitle;
        this.currentTrackUri = trackUri;
        this.isPlaying = true;
        this.spotifyAppRemote.getPlayerApi().play(trackUri);
    }

    public void stop() {
        this.currentTitle = null;
        this.currentTrackUri = null;
        this.isPlaying = false;
        this.spotifyAppRemote.getPlayerApi().pause();
    }

    public void setPlayIconToAll() {
        for (ImageButton imageButton : this.imageButtons) {
            imageButton.setImageResource(R.drawable.icons_play);
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public List<ImageButton> getImageButtons() {
        return imageButtons;
    }

    public String getCurrentTrackUri() {
        return currentTrackUri;
    }
}

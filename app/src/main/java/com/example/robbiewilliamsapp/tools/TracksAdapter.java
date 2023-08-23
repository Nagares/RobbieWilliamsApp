package com.example.robbiewilliamsapp.tools;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.robbiewilliamsapp.R;
import com.example.robbiewilliamsapp.models.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TracksAdapter extends ArrayAdapter<Track> {

    public TracksAdapter(@NonNull Context context, int resource, @NonNull List<Track> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Track track = getItem(position);
        Log.d("TrackAdapter", "Convert track to view item");

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.record_item, parent, false);
        }
        TextView tvRecordName = convertView.findViewById(R.id.tvRecordName);
        TextView tvRecordArtist = convertView.findViewById(R.id.tvRecordArtist);
        TextView textAlbum = convertView.findViewById(R.id.textAlbum);
        TextView textRelease = convertView.findViewById(R.id.textRelease);
        ImageButton ibtRecord = convertView.findViewById(R.id.ibtRecord);
        ImageView ivRecordArtist = convertView.findViewById(R.id.ivRecordArtist);

        tvRecordName.setText(track.getName());
        tvRecordArtist.setText(track.getArtists().get(0).getName());
        textAlbum.setText(track.getAlbum().getName());
        textRelease.setText(track.getAlbum().getRelease_date());
        Picasso.get().load(track.getAlbum().getImages().get(1).getUrl()).into(ivRecordArtist);

        // add to the list for later usages
        SpotifyAppRemoteClient.getInstance().getImageButtons().add(ibtRecord);

        ibtRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageButton ibt = (ImageButton) view;

                try {
                    if (!SpotifyAppRemoteClient.getInstance().isPlaying() ||
                            !track.getUri().equals(SpotifyAppRemoteClient.getInstance().getCurrentTrackUri())
                    ) {
                        SpotifyAppRemoteClient.getInstance().setPlayIconToAll();
                        ibtRecord.setImageResource(R.drawable.icons_stop);
                        ibt.setContentDescription(track.getUri());
                        Log.d("TrackAdapter", "Track preview url:" + track.getPreview_url());
                        SpotifyAppRemoteClient.getInstance().play(track.getUri(), track.getName());

                    } else {
                        ibtRecord.setImageResource(R.drawable.icons_play);
                        ibt.setContentDescription("");
                        SpotifyAppRemoteClient.getInstance().stop();
                    }
                } catch (Exception e) {
                    Log.d("TrackAdapter", "Failed to start track:" + track.getUri() + " exception:" + e.getMessage());
                }
            }
        });

        return convertView;
    }

}

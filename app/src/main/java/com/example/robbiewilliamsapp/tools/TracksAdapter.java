package com.example.robbiewilliamsapp.tools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.robbiewilliamsapp.R;
import com.example.robbiewilliamsapp.models.Track;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class TracksAdapter extends ArrayAdapter<Track> {
    MediaPlayer mediaPlayer ;

    public TracksAdapter(@NonNull Context context, int resource, @NonNull List<Track> objects) {

        super(context, resource, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Track track = getItem(position);
        Log.d("###","");

        if(convertView == null){
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



        //TODO  handle button

        ibtRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = new MediaPlayer();
                ImageButton ibt = (ImageButton) view;

                try {


                if (ibt.getContentDescription().equals(" ")) {

                    ibtRecord.setImageResource(R.drawable.icons_play);
                    ibt.setContentDescription(".");
                    Log.d("&&&&#",track.getPreview_url()+"**");
                    playMedia(track.getPreview_url());         // TODO need fined work url or uri
                                                              //TODO playMedia

                }else{
                        ibtRecord.setImageResource(R.drawable.icons_pause);
                        ibt.setContentDescription(" ");
                        mediaPlayer.stop();

                }
                }catch (Exception e){
                    Log.d("&&&&",e.getMessage());
                }


            }
        });

    return convertView;
    }

    public void playMedia(String mediaUrl) {
        Log.d("&&&&#",mediaUrl+"**");

        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource( mediaUrl);
            mediaPlayer.prepareAsync();
            mediaPlayer.start();
        } catch (IOException e) {
            Log.d("&&&&",e.getMessage());
        }
    }


}

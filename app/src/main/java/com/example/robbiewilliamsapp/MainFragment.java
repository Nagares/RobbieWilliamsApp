package com.example.robbiewilliamsapp;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.robbiewilliamsapp.models.ArtistAllInfo;
import com.example.robbiewilliamsapp.models.ClientCredo;
import com.example.robbiewilliamsapp.tools.RetrofitService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {


    TextView tvName;
    TextView Popularity;
    TextView tvGenres;
    TextView tvFollowers;
    ImageView ivArtist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        tvName = view.findViewById(R.id.tvName);
        Popularity = view.findViewById(R.id.tvPopularity);
        tvGenres = view.findViewById(R.id.tvGenres);
        tvFollowers = view.findViewById(R.id.tvFollowers);
        ivArtist = view.findViewById(R.id.ivArtist);

        ClientCredo clientCredo = ClientCredo.getInstance();
        String header = clientCredo.getClientToken();


        Call<ArtistAllInfo> call = RetrofitService.getInstance().getClientApi().getArtist(header);


        call.enqueue(new Callback<ArtistAllInfo>() {
            @Override
            public void onResponse(Call<ArtistAllInfo> call, Response<ArtistAllInfo> response) {
                ArtistAllInfo artist = response.body();
                String genre = "";

                if (artist != null && artist.getGenres() != null ) {
                     genre = String.join(" ", artist.getGenres());
                }

                try {

                    tvName.setText(artist.getName());
                    Popularity.setText(String.valueOf(artist.getPopularity()));
                    tvGenres.setText(genre);
                    tvFollowers.setText(String.valueOf(artist.getFollowers().getTotal()));
                    Picasso.get().load(artist.getImages().get(1).getUrl()).into(ivArtist);

                    Log.d("###", artist.getImages().get(0).getHeight() + "");

                } catch (Exception ex) {
                    Log.d("###", ex.getMessage());
                }

            }

            @Override
            public void onFailure(Call<ArtistAllInfo> call, Throwable t) {
                Log.d("&&&&&", t.getMessage());
            }
        });

        return view;
    }


}
package com.example.robbiewilliamsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.robbiewilliamsapp.models.ArtistAllInfo;
import com.example.robbiewilliamsapp.models.ClientCredo;
import com.example.robbiewilliamsapp.models.Root;
import com.example.robbiewilliamsapp.models.Track;
import com.example.robbiewilliamsapp.tools.RetrofitService;
import com.example.robbiewilliamsapp.tools.TracksAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MusicFragment extends Fragment {

    ListView listRecords = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        listRecords = view.findViewById(R.id.listRecords);


         ClientCredo clientCredo = ClientCredo.getInstance();
        String header = clientCredo.getClientToken();



        Call<Root> call = RetrofitService.getInstance().getClientApi().getArtistMusic(header);
        Log.d("###",""+header);

        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Root root = response.body();
                List<Track> tracks =root.getTracks();
                Log.d("###",""+tracks);

                TracksAdapter adapter = new TracksAdapter(getContext(), 0, tracks);
                listRecords.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("&&&&&", t.getMessage());
            }
        });




        return view;
    }
}
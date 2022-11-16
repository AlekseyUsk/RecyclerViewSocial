package ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hfad.recyclerviewsocial.R;

import repository.LocalRepositoryImpl;

public class SocialNetworkFragment extends Fragment implements OnItemClickListener {

    SocialNetworkAdapter socialNetworkAdapter;

    public static SocialNetworkFragment newInstance() {
        SocialNetworkFragment fragment = new SocialNetworkFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_social_network, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        initRecycler(view);

    }

    void initAdapter() {
        socialNetworkAdapter = new SocialNetworkAdapter();
        LocalRepositoryImpl localRepositoryImpl = new LocalRepositoryImpl(requireContext().getResources());
        socialNetworkAdapter.setData(localRepositoryImpl.init()); // 4 - передать в адаптер данные
        socialNetworkAdapter.setOnItemClickListener(this);
    }

    void initRecycler(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);  // 1 - нашел список
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);                      // 2 - связал с layoutManager
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(socialNetworkAdapter);                     // 3 - связал его со своим адаптером,чтобы кто то говорил ему что отрисовывать
    }

    String[] getData() {
        String[] data = getResources().getStringArray(R.array.titles);
        return data;
    }

    @Override
    public void onItemClick(int position) {
        String[] data = getData();
        Toast.makeText(requireContext(), "нажали на" + data[position], Toast.LENGTH_SHORT).show();
    }
}
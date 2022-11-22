package ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hfad.recyclerviewsocial.R;

import repository.CardData;
import repository.CardSource;
import repository.LocalRepositoryImpl;

public class SocialNetworkFragment extends Fragment implements OnItemClickListener {

    SocialNetworkAdapter socialNetworkAdapter;
    CardSource data;

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
        setHasOptionsMenu(true); // определил меню
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.cards_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                data.addCardData(new CardData("Заголовок новой карточки " + data.size(),
                        "Описание новой карточки " + data.size(), R.drawable.nature1, false));
                socialNetworkAdapter.notifyItemInserted(data.size() - 1);
                return true;
            }
            case R.id.action_clear: {
                data.clearCardsData();
                socialNetworkAdapter.notifyDataSetChanged();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    void initAdapter() {
        socialNetworkAdapter = new SocialNetworkAdapter();
        data = new LocalRepositoryImpl(requireContext().getResources()).init();
        socialNetworkAdapter.setData(data); // 4 - передать в адаптер данные
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
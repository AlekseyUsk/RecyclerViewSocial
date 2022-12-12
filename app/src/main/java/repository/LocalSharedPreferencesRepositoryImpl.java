package repository;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hfad.recyclerviewsocial.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LocalSharedPreferencesRepositoryImpl implements CardSource {
    private List<CardData> dataSource;
    private SharedPreferences sharedPreferences;

    static final String KEY_CELL_1 = "cell_1";
    public static final String KEY_SP_2 = "key_sp_2";

    public LocalSharedPreferencesRepositoryImpl(SharedPreferences sharedPreferences) {
        dataSource = new ArrayList<CardData>();
        this.sharedPreferences = sharedPreferences;

    }

    public LocalSharedPreferencesRepositoryImpl init() {
        String savedCardData = sharedPreferences.getString(KEY_CELL_1, null);
        if (savedCardData != null) {
            Type type = new TypeToken<ArrayList<CardData>>() {// рефлексия? надо изучить
            }.getType();
            dataSource = (new GsonBuilder().create().fromJson(savedCardData, type));
        }
        return this;
    }

    @Override
    public int size() {
        return dataSource.size();  // наш источник умеет возвращать свой размер
    }

    @Override
    public List<CardData> getAllCardsData() {
        return dataSource;         // все карточки
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);  // определенную карточку по позиции
    }

    @Override
    public void clearCardsData() {
        dataSource.clear(); // у нашего списка вызвал команду clear - очистка
    }

    @Override
    public void addCardData(CardData cardData) {
        dataSource.add(cardData);  // добавил
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_CELL_1, new GsonBuilder().create().toJson(dataSource));
        editor.apply();
    }

    @Override
    public void deleteCardData(int position) {
        dataSource.remove(position); // удалил по позиции
    }

    @Override
    public void updateCardData(int position, CardData newCardData) {
        dataSource.set(position, newCardData); // обновил карточку по позиции
    }


}

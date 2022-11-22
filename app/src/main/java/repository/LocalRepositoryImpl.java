package repository;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.hfad.recyclerviewsocial.R;

import java.util.ArrayList;
import java.util.List;

//todo 2 - создаем репозиторий лок или онлайн и имплементируем поведение CardSource
// после чего CardSource передадим в адаптер
public class LocalRepositoryImpl implements CardSource {

    private List<CardData> dataSource;
    private Resources resources;

    public LocalRepositoryImpl(Resources resources) {
        dataSource = new ArrayList<CardData>();
        this.resources = resources;

    }

    public LocalRepositoryImpl init() {
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        TypedArray pictures = resources.obtainTypedArray(R.array.pictures);

        for (int i = 0; i < titles.length; i++) {
            dataSource.add(new CardData(titles[i], titles[i], pictures.getResourceId(i, 0), false));
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

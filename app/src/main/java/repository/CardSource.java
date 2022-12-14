package repository;

import java.util.List;

import repository.CardData;

//Todo 1 -  Для начало определяем источник данных и что он будет уметь
public interface CardSource {

    int size();                         // умеет возвращать свой размер

    List<CardData> getAllCardsData();   // умеет возвращать свой список

    CardData getCardData(int position); // умеет возвращать конкретную карточку

    void clearCardsData(); // очистить карточки

    void addCardData(CardData cardData); // добавить карточку

    void deleteCardData(int position); // удалить карточку

    void updateCardData(int position, CardData newCardData); // обновить карточку

}

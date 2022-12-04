package publisher;

// сущьность которая будет этим всем управлять и она имеет список всех Observer

import java.util.ArrayList;
import java.util.List;

import repository.CardData;

public class Publisher {
    private List<Observer> observers;

    //так как он не статичный создал конструтор и обновил список слушателей чтобы он был !=null
    public Publisher() {
        observers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {  // добавляю нового слушателя(observer) в свой список
        observers.add(observer);
    }

    public void unSubscribe(Observer observer) { // удаление из списка
        observers.remove(observer);
    }

    // проходим по списку и у каждого observer вызываем метод получить сообщение и передаем cardData  ->
    public void sendMessage(CardData cardData) {
        for (Observer observer : observers) {
            observer.receiveMessage(cardData);
        }
    }
}

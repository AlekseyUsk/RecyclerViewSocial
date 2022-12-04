package publisher;

import repository.CardData;

// сущьность которая будет получать в себя сообщения

public interface Observer {
    public void receiveMessage(CardData cardData); // метод получить сообщение
}

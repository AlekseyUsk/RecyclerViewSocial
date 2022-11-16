package repository;

public class CardData {

    public String getTitle() {
        return title;
    }

    private String title;

    public String getDescription() {
        return description;
    }

    public int getPicture() {
        return picture;
    }

    public boolean isLike() {
        return like;
    }

    private String description;
    private int picture;

    public void setLike(boolean like) {
        this.like = like;
    }

    private boolean like;

    public CardData(String title, String description, int picture, boolean like) {
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.like = like;
    }
}

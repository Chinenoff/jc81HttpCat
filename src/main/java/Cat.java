import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
    private final String id; //уникальный идентификатор записи
    private final String text; // сообщение
    private final String type; // тип
    private final String user; // описание пользователя
    private final Integer upvotes; // голоса

    public Cat(                   //конструктор с jackson
                                  @JsonProperty("id") String id,
                                  @JsonProperty("text") String text,
                                  @JsonProperty("type") String type,
                                  @JsonProperty("user") String user,
                                  @JsonProperty("upvotes") Integer upvotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", upvotes=" + upvotes +
                '}';
    }
}
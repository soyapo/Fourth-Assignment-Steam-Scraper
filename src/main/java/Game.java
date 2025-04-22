import java.util.Objects;

public class Game {
    //base variables
    private String name;
    private double rating;
    private int price;

    //constructor
    public Game(String name, double rating, int price) {
        setName(name);
        setRating(rating);
        setPrice(price);
    }

    //getter methods
    public String getName() {
        return name;
    }
    public double getRating() {
        return rating;
    }
    public int getPrice() {
        return price;
    }

    //setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Double.compare(game.rating, rating) == 0 &&
                price == game.price &&
                Objects.equals(name, game.name);
    }
}

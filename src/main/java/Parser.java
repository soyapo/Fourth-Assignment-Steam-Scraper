import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Game> games = new ArrayList<>();

    public static List<Game> sortByName(int Dir){
        List<Game> sortedByName = new ArrayList<>(games);

        if(Dir == 1)
            sortedByName.sort(Comparator.comparing(Game::getName));
        else
            sortedByName.sort(Comparator.comparing(Game::getName).reversed());

        return sortedByName;
    }

    public static List<Game> sortByRating(int Dir){
        List<Game> sortedByRating = new ArrayList<>(games);

        if(Dir == 1)
            sortedByRating.sort(Comparator.comparing(Game::getRating).reversed());
        else
            sortedByRating.sort(Comparator.comparing(Game::getRating));

        return sortedByRating;
    }

    public static List<Game> sortByPrice(int Dir){
        List<Game> sortedByPrice = new ArrayList<>(games);

        if(Dir == 1)
            sortedByPrice.sort(Comparator.comparing(Game::getPrice));
        else
            sortedByPrice.sort(Comparator.comparing(Game::getPrice).reversed());

        return sortedByPrice;
    }

    public static void setUp(){
        try{
            //Load and parst HTML Document
            File GameFile = new File("src/Resources/Video_Games.html");
            Document GameDoc = Jsoup.parse(GameFile, "UTF-8");

            //Make a list of all the games
            Element MainRow = GameDoc.getElementById("MainRow");
            Elements GameDivs  = MainRow.getElementsByClass("col-md-4 game");

            //iterate and extract game data
            for (Element GameData : GameDivs) {
                String name = GameData.getElementsByClass("game-name").first().text();
                Double rating  = Double.parseDouble(GameData.getElementsByClass("game-rating").first().text().substring(0, 3));
                Integer price = Integer.parseInt(GameData.getElementsByClass("game-price").first().text().substring(0, 2));

                //Make a Game instance and add it to list
                Game game = new Game(name, rating, price);
                games.add(game);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

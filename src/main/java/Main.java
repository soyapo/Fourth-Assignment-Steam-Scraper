
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Parser.setUp();
        List<Game> SortedGameList = new ArrayList<>();

        System.out.println("Welcome to game data Extractor\n");

        System.out.println("Sort by:");
        System.out.println("1- Name");
        System.out.println("2- Rating");
        System.out.println("3- Price");
        int SortType = SortChoice();

        System.out.println("Sort direction:");
        System.out.println("1- Ascending");
        System.out.println("2- Descending");
        int SortDir = SortChoice();

        SortedGameList = switch (SortType) {
            case 1 -> Parser.sortByName(SortDir);
            case 2 -> Parser.sortByRating(SortDir);
            case 3 -> Parser.sortByPrice(SortDir);
            default -> SortedGameList;
        };

        clearScreen();

        for(Game u: SortedGameList){
            System.out.println(u.getName() + "\n" + u.getRating() + "/5  -  " + u.getPrice() + "$\n");
        }
    }
    public static int SortChoice(){
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter your desired choice: ");
        try{
            int type = cin.nextInt();
            if(type >= 1 && type <= 3){ return type; }
            else{SortChoice();}
        }
        catch (Exception e){
            SortChoice();
        }

        return 0;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

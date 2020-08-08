package project;

import java.io.InputStream;
import java.util.Map;

public class CommandHandler {
    public Map<String,String> GameList;
    private InputReader reader = new InputReader();

    /**
     * constructor to inject the map data type for game storage
     * @param newlist
     */
    public CommandHandler(Map<String,String> newlist){
        this.GameList = newlist;
    }

    /**
     * read game and genre, then enter into map
     * @param source
     * @param source2
     */
    public void Add(InputStream source, InputStream source2){
        String game;
        String genre;

        System.out.println("Enter game title:");
        game = reader.Read(source);

        System.out.println("Enter game genre:");
        genre = reader.Read(source2);

        this.GameList.put(game, genre);
    }
    
    /**
     * remove game from map
     * @param source
     */
    public void Remove(InputStream source){
        String game;

        System.out.println("Enter game to remove:");
        game = reader.Read(source);

        this.GameList.remove(game);
    }

    /**
     * output full map
     */
    public void Display(){
        System.out.println("-------------------------");
        this.GameList.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println("-------------------------");
    }
}
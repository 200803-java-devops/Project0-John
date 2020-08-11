package project;

import java.io.InputStream;
import java.util.Map;

public class CommandHandler {
    public Map<String,String> GameList;
    private InputReader reader = new InputReader();
    private String[] commands = {"commands", "exit", "add", "remove", "display"};

    /**
     * constructor to inject the map data type for game storage
     * @param newlist
     */
    public CommandHandler(Map<String,String> newlist){
        this.GameList = newlist;
    }

    public boolean Handle(InputStream source){
        String command;
        command = reader.Read(source);
        if(command.equals(commands[1])){
            return true;
        }
        if(command.equals(commands[0])){
            for (String i : commands) {
                System.out.println(i);
            }
        }
        if(command.equals(commands[2])){
            System.out.println("Enter game title:");
            InputStream in1 = System.in;
            System.out.println("Enter game genre:");
            InputStream in2 = System.in;
            this.Add(in1, in2);
        }
        if(command.equals(commands[3])){
            System.out.println("Enter game to remove:");
            InputStream in = System.in;
            this.Remove(in);
        }
        if(command.equals(commands[4])){
            this.Display();
        }

        return false;
    }

    /**
     * read game and genre, then enter into map
     * @param source
     * @param source2
     */
    public void Add(InputStream source, InputStream source2){
        String game;
        String genre;
        game = reader.Read(source);
        genre = reader.Read(source2);
        this.GameList.put(game, genre);
    }
    
    /**
     * remove game from map
     * @param source
     */
    public void Remove(InputStream source){
        String game;
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
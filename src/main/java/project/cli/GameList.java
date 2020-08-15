package project.cli;

import java.util.ArrayList;
import java.util.List;

public class GameList {
    public List<Game> gamelist;

    public GameList(){
        this.gamelist = new ArrayList<Game>();
    }

    public void add(Game game){
        this.gamelist.add(game);
    }

    public void remove(String title){
        this.gamelist.removeIf(n -> n.title.equals(title));
    }

    public void display(){
        System.out.println("-------------------------");
        this.gamelist.forEach(game -> System.out.println(game.title + " - " + game.genre + " - " + game.control));
        System.out.println("-------------------------");    
    }
}
package project.cli;

import java.util.ArrayList;
import java.util.List;

import project.data.Adder;
import project.data.Remover;

public class GameList {
    public List<Game> gamelist;

    public GameList(){
        this.gamelist = new ArrayList<Game>();
    }

    public void add(Game game){
        this.gamelist.add(game);
        Adder.addGame(game);
    }

    public void initAdd(Game game){
        this.gamelist.add(game);
    }

    public void remove(String title){
        this.gamelist.removeIf(n -> n.title.equals(title));
        Remover.removeGame(title);
    }

    public void display(){
        System.out.println("-------------------------");
        this.gamelist.forEach(game -> System.out.println(game.title + " - " + game.genre + " - " + game.control));
        System.out.println("-------------------------");    
    }

    public boolean equals(GameList otherlist){
        return this.gamelist.equals(otherlist.gamelist);
    }
}
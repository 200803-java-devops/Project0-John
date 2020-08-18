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
        Runnable runnable = new Adder(game);
        Thread thread = new Thread(runnable);
        thread.start();
        this.gamelist.add(game);
    }

    public void initAdd(Game game){
        this.gamelist.add(game);
    }

    public void remove(String title){
        Runnable runnable = new Remover(title);
        Thread thread = new Thread(runnable);
        thread.start();
        this.gamelist.removeIf(n -> n.title.equals(title));
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
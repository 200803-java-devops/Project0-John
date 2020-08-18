package project.cli;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import project.data.Adder;
import project.data.Getter;
import project.data.Remover;

public class GameList {
    public List<Game> gamelist;
    public InputReader reader = new InputReader();

    public GameList() {
        this.gamelist = new ArrayList<Game>();
    }

    public void add(Game game) {
        Runnable runnable = new Adder(game);
        Thread thread = new Thread(runnable);
        thread.start();
        this.gamelist.add(game);
    }

    public void testAdd(Game game) {
        this.gamelist.add(game);
    }

    public void initAdd(Game game) {
        this.gamelist.add(game);
    }

    public void remove(String title) {
        Runnable runnable = new Remover(title);
        Thread thread = new Thread(runnable);
        thread.start();
        this.gamelist.removeIf(n -> n.title.equals(title));
    }

    public void display(String displayType) {
        GameList displayList = new GameList();
        Game temp = new Game();
        String input;
        if (displayType.equals("1")) {
            System.out.println("What genre would you like listed?");
            temp.genres.forEach((key, value) -> System.out.println(key + " - " + value));
            input = reader.Read(System.in);
            try {
                displayList = Getter.getGenre(temp.genres.get(input));
            } catch (SQLException e) {
                System.err.println("getgenre call for display function in gamelist failed");
            }
        }
        else if (displayType.equals("2")){
            System.out.println("What control type would you like listed?");
            temp.controls.forEach((key, value) -> System.out.println(key + " - " + value));
            input = reader.Read(System.in);
            try {
                displayList = Getter.getControl(temp.controls.get(input));
            } catch (SQLException e) {
                System.err.println("getcontrol call for display function in gamelist failed");
            }
        }
        else if (displayType.equals("3")){
            System.out.println("Do you want started or not started games?");
            System.out.println("1 - started");
            System.out.println("2 - not started");
            input = reader.Read(System.in);
            if(input == "1"){
                try {
                    displayList = Getter.getStarted(true);
                } catch (SQLException e) {
                    System.err.println("getstarted call for display function in gamelist failed");
                }
            }
            else{
                try {
                    displayList = Getter.getStarted(false);
                } catch (SQLException e) {
                    System.err.println("getstarted call for display function in gamelist failed");
                }
            }
        }
        else{
            displayList.gamelist = this.gamelist;
        }
        System.out.println("-------------------------");
        displayList.gamelist.forEach(game -> System.out.println(game.title + " - " + game.genre + " - " + game.control + " - " + game.started));
        System.out.println("-------------------------");    
    }

    public boolean equals(GameList otherlist){
        boolean eq = true;
        if(this.gamelist.size() != otherlist.gamelist.size()){
            eq = false;
        }
        for(int i = 0; i < this.gamelist.size(); i++){
            eq = this.gamelist.get(i).equals(otherlist.gamelist.get(i));
        }
        return eq;
    }

    public void getRand(String groupType){
        GameList displayList = new GameList();
        Game temp = new Game();
        String input;
        if (groupType.equals("1")) {
            System.out.println("What genre would you like listed?");
            temp.genres.forEach((key, value) -> System.out.println(key + " - " + value));
            input = reader.Read(System.in);
            try {
                displayList = Getter.getGenre(temp.genres.get(input));
            } catch (SQLException e) {
                System.err.println("getgenre call for display function in gamelist failed");
            }
        }
        else if (groupType.equals("2")){
            System.out.println("What control type would you like listed?");
            temp.controls.forEach((key, value) -> System.out.println(key + " - " + value));
            input = reader.Read(System.in);
            try {
                displayList = Getter.getControl(temp.controls.get(input));
            } catch (SQLException e) {
                System.err.println("getcontrol call for display function in gamelist failed");
            }
        }
        else if (groupType.equals("3")){
            System.out.println("Do you want started or not started games?");
            System.out.println("1 - started");
            System.out.println("2 - not started");
            input = reader.Read(System.in);
            if(input == "1"){
                try {
                    displayList = Getter.getStarted(true);
                } catch (SQLException e) {
                    System.err.println("getstarted call for display function in gamelist failed");
                }
            }
            else{
                try {
                    displayList = Getter.getStarted(false);
                } catch (SQLException e) {
                    System.err.println("getstarted call for display function in gamelist failed");
                }
            }
        }
        else{
            displayList.gamelist = this.gamelist;
        }
        Random rand = new Random();
        System.out.println(displayList.gamelist.get(rand.nextInt(displayList.gamelist.size())).title);
    }
}
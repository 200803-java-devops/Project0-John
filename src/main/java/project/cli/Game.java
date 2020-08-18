package project.cli;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Game {
    public String title;
    public String genre;
    public String control;
    public Boolean started;
    private InputReader reader;
    public Map<String, String> genres;
    public Map<String, String> controls;
    public Map<String, Boolean> starteds;

    /**
     * Constructor for method tests
     */
    public Game(){
        reader = new InputReader();
        genres = new HashMap<String, String>();
        controls = new HashMap<String, String>();
        starteds = new HashMap<String, Boolean>();
        genres.put("1", "RPG");
        genres.put("2", "Strategy");
        genres.put("3", "Shooter");
        genres.put("4", "MOBA");
        genres.put("5", "Other");
        controls.put("1", "First Person");
        controls.put("2", "Third Person");
        controls.put("3", "Top Down");
        controls.put("4", "Other");
        starteds.put("1", false);
        starteds.put("2", true);
    }

    /**
     * Constructor for method and general tests
     * @param t the games title
     * @param g the games genre
     * @param c the games control method
     */
    public Game(String t, String g, String c, Boolean s){
        this.title = t;
        this.genre = g;
        this.control = c;
        this.started = s;
    }

    /**
     * Use case constructor for program
     * @param source input source (expected System.in)
     */
    public Game(InputStream source1, InputStream source2, InputStream source3, InputStream source4){
        reader = new InputReader();
        genres = new HashMap<String, String>();
        controls = new HashMap<String, String>();
        starteds = new HashMap<String, Boolean>();
        genres.put("1", "RPG");
        genres.put("2", "Strategy");
        genres.put("3", "Shooter");
        genres.put("4", "MOBA");
        genres.put("5", "Other");
        controls.put("1", "First Person");
        controls.put("2", "Third Person");
        controls.put("3", "Top Down");
        controls.put("4", "Other");
        starteds.put("1", false);
        starteds.put("2", true);
        this.setTitle(source1);
        this.setGenre(source2);
        this.setControl(source3);
        this.setStarted(source4);
    }

    public void setTitle(InputStream source){
        System.out.println("Please enter game title: ");
        this.title = reader.Read(source);
    }

    public void setGenre(InputStream source){
        boolean genreSet = false;
        while(!genreSet){
            System.out.println("Please enter number associated with game genre: ");
            genres.forEach((key, value) -> System.out.println(key + " - " + value));
            String input = reader.Read(source);
            if(genres.containsKey(input)){
                this.genre = genres.get(input);
                genreSet = true;
            }else{
                System.out.println("Input not valid");
            }
        }
    }

    public void setControl(InputStream source){
        boolean controlSet = false;
        while(!controlSet){
            System.out.println("Please enter number associated with game control method: ");
            controls.forEach((key, value) -> System.out.println(key + " - " + value));
            String input = reader.Read(source);
            if(controls.containsKey(input)){
                this.control = controls.get(input);
                controlSet = true;
            }else{
                System.out.println("Input not valid");
            }
        }
    }

    public void setStarted(InputStream source){
        boolean startSet = false;
        while(!startSet){
            System.out.println("Have you started this game yet?");
            starteds.forEach((key, value) -> System.out.println(key + " - " + value));
            String input = reader.Read(source);
            if(starteds.containsKey(input)){
                this.started = starteds.get(input);
                startSet = true;
            }else{
                System.out.println("Input not valid");
            }
        }
    }

    public boolean equals(Game game){
        if(this.title != game.title){
            return false;
        }else if(this.genre != game.genre){
            return false;
        }else if(this.control != game.control){
            return false;
        }else if(this.started != game.started){
            return false;
        }else{
            return true;
        }
    }
}
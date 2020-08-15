package project.cli;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Game {
    public String title;
    public String genre;
    public String control;
    private InputReader reader;
    private Map<String, String> genres;
    private Map<String, String> controls;

    /**
     * Constructor for method tests
     */
    public Game(){
        reader = new InputReader();
        genres = new HashMap<String, String>();
        controls = new HashMap<String, String>();
        genres.put("1", "RPG");
        genres.put("2", "Strategy");
        genres.put("3", "Shooter");
        genres.put("4", "MOBA");
        genres.put("5", "Other");
        controls.put("1", "First Person");
        controls.put("2", "Third Person");
        controls.put("3", "Top Down");
        controls.put("4", "Other");
    }

    /**
     * Constructor for method and general tests
     * @param t the games title
     * @param g the games genre
     * @param c the games control method
     */
    public Game(String t, String g, String c){
        this.title = t;
        this.genre = g;
        this.control = c;
    }

    /**
     * Use case constructor for program
     * @param source input source (expected System.in)
     */
    public Game(InputStream source1, InputStream source2, InputStream source3){
        reader = new InputReader();
        genres = new HashMap<String, String>();
        controls = new HashMap<String, String>();
        genres.put("1", "RPG");
        genres.put("2", "Strategy");
        genres.put("3", "Shooter");
        genres.put("4", "MOBA");
        genres.put("5", "Other");
        controls.put("1", "First Person");
        controls.put("2", "Third Person");
        controls.put("3", "Top Down");
        controls.put("4", "Other");
        this.setTitle(source1);
        this.setGenre(source2);
        this.setControl(source3);
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
}
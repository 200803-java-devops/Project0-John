package project.cli;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private InputReader reader = new InputReader();
    private Map<String, String> commands = new HashMap<String, String>();
    private Map<String, String> displayType = new HashMap<String, String>();
    public GameList gamelist; 

    /**
     * Command Handler class stores gamelist and translates user input to execute correct command
     * constructor to inject the map data type for game storage
     * @param gl game list object
     */
    public CommandHandler(GameList gl){
        this.gamelist = gl;
        commands.put("1", "exit");
        commands.put("2", "add");
        commands.put("3", "remove");
        commands.put("4", "display");
        commands.put("5", "get random game");
        displayType.put("1", "genre");
        displayType.put("2", "control type");
        displayType.put("3", "started");
        displayType.put("4", "all");
    }

    /**
     * Helper method to display available commands
     */
    public void showCommands(){
        System.out.println("Type number associated with desired command:");
        this.commands.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    /**
     * Method to read input stream and execute correct gamelist method for command
     * @param source input command, abstracted as input stream for testing purposes
     * @return true to continue program, false if exit command is given
     */
    public boolean Handle(InputStream source){
        String command;
        command = reader.Read(source);
        if(command.equals("1")){
            return true;
        }
        if(command.equals("2")){
            gamelist.add(new Game(System.in, System.in, System.in, System.in));
        }
        if(command.equals("3")){
            System.out.println("Please enter title of game to remove: ");
            gamelist.remove(reader.Read(System.in));
        }
        if(command.equals("4")){
            System.out.println("How would you like to sort the games list?");
            displayType.forEach((key, value) -> System.out.println(key + " - " + value));
            String command2 = reader.Read(System.in);
            gamelist.display(command2);
        }
        if(command.equals("5")){
            System.out.println("From what set of games should a game be selected?");
            displayType.forEach((key, value) -> System.out.println(key + " - " + value));
            String command2 = reader.Read(System.in);
            gamelist.getRand(command2);
        }
        return false;
    }
}
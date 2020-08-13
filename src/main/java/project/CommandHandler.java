package project;

import java.io.InputStream;

public class CommandHandler {
    private InputReader reader = new InputReader();
    private String[] commands = {"commands", "exit", "add", "remove", "display"};
    public GameList gamelist; 

    /**
     * constructor to inject the map data type for game storage
     * @param gl game list object
     */
    public CommandHandler(GameList gl){
        this.gamelist = gl;
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
            gamelist.add(new Game(System.in, System.in, System.in));
        }
        if(command.equals(commands[3])){
            System.out.println("Please enter title of game to remove: ");
            gamelist.remove(reader.Read(System.in));
        }
        if(command.equals(commands[4])){
            gamelist.display();
        }

        return false;
    }
}
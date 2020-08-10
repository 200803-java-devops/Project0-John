package project;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) {
        CommandHandler handler = new CommandHandler(new HashMap<String, String>());
        String command= "";
        String exit = "exit";
        
        while(!command.equals(exit)){
            System.out.println("Enter command or type \"commands\" to see a list of commands, or \"exit\" to exit");
            command = handler.Handle(System.in);
        }
    }
}

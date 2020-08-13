package project;

import java.io.InputStream;

/**
 * class to run program, abstraction to keep main clear
 */
public class ProgramOperations {
    public static boolean exitStatus;
    private static CommandHandler handler = new CommandHandler(new GameList());

    /**
     * method that runs the program from created 
     * @param source
     */
    public static void RunApp(InputStream source){
        exitStatus = false;
        while(!exitStatus){
            System.out.println("Enter command or type \"commands\" to see a list of commands, or \"exit\" to exit");
            exitStatus = handler.Handle(source);
        }
    }
}
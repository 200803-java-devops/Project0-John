package project.cli;

import java.io.InputStream;
import java.sql.SQLException;

import project.data.Getter;

/**
 * class to run program, abstraction to keep main clear
 */
public class ProgramOperations {
    public static boolean exitStatus;
    private static CommandHandler handler;

    /**
     * method that runs the program from created
     * 
     * @param source
     */
    public static void RunApp(InputStream source) {
        try {
            handler = new CommandHandler(Getter.getAll());
        } catch (SQLException e) {
            System.err.println("getall method on program run fail");
        }
        exitStatus = false;
        while(!exitStatus){
            handler.showCommands();
            exitStatus = handler.Handle(source);
        }
    }
}
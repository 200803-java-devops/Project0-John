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
     * method that runs the program, copies existing entries in database to initial gamelist
     * @param source source of user input, abstracted to inputstream for testing
     */
    public void RunApp(InputStream source) {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());
        logger.info(java.time.LocalTime.now() + " Program Running");
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
package project;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) {
        String[] commands = {"commands", "exit"};
        String command = "";
        InputReader reader = new InputReader();
        
        while(!command.equals(commands[1])){
            System.out.println("Enter command or type \"commands\" to see a list of commands, or \"exit\" to exit");
            command = reader.Read(System.in);
            if(command.equals(commands[0])){
                for (String i : commands) {
                    System.out.println(i);
                }
            }
        }
    }
}

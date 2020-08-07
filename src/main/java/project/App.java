package project;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) {
        String[] commands = {"commands", "exit"};
        String command = "";
        Scanner input = null;
        String exit = "exit";

        while(!command.equals(exit)){
            input = new Scanner(System.in);
            System.out.println("Enter command or type \"commands\" to see a list of commands, or \"exit\" to exit");
            command = input.nextLine();
            if(command.equals(commands[0])){
                for (String i : commands) {
                    System.out.println(i);
                }
            }
        }
        input.close();
    }
}

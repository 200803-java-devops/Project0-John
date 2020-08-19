package project;

import project.cli.ProgramOperations;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) {
        ProgramOperations ops = new ProgramOperations();
        ops.RunApp(System.in);
    }
}

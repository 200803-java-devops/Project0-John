package project.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class that reads user command line input and outputs the command as a string
 */
public class InputReader {
    private BufferedReader reader;

    public InputReader() {

    }

    public String Read(InputStream source) {
        this.reader = new BufferedReader(new InputStreamReader(source));
        String command = "";
        try {
            command = reader.readLine();
        } catch (IOException e) {
            System.err.println("InputReader read line failed");
        }

        return command;
    }
}
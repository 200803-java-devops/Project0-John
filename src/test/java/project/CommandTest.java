package project;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CommandTest {
    
    /**
     * Test that provided input is successfully added to map
     */
    @Test
    public void AddTest(){
        Map<String, String> expected = new HashMap<>();
        expected.put("Skyrim", "RPG");

        Map<String, String> actual = new HashMap<>();
        CommandHandler handler = new CommandHandler(actual);
        String input1 = "Skyrim";
        InputStream in = new ByteArrayInputStream(input1.getBytes());
        String input2 = "RPG";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        handler.Add(in, in2);
        assertTrue(expected.equals(handler.GameList));
    }

    /**
     * Test that named game is sucessfully removed from map
     */
    @Test
    public void RemoveTest(){
        Map<String,String> expected = new HashMap<>();

        Map<String,String> actual = new HashMap<>();
        actual.put("Skyrim", "RPG");
        CommandHandler handler = new CommandHandler(actual);
        String input = "Skyrim";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        handler.Remove(in);
        assertTrue(expected.equals(handler.GameList));
    }
}
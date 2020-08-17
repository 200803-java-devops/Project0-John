package project.clitest;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import project.cli.Game;

public class GameTest {
    Game expected = new Game("Skyrim", "RPG", "First Person");
    
    @Test
    public void setTitleTest(){
        Game actual = new Game();
        String title = "Skyrim";
        InputStream in = new ByteArrayInputStream(title.getBytes());
        actual.setTitle(in);
        assertTrue(expected.title.equals(actual.title));
    }

    @Test
    public void setGenreTest(){
        Game actual = new Game();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        actual.setGenre(in);
        assertTrue(expected.genre.equals(actual.genre));
    }

    @Test
    public void setControlTest(){
        Game actual = new Game();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        actual.setControl(in);
        assertTrue(expected.control.equals(actual.control));
    }

    @Test
    public void constructorTest(){
        String title = "Skyrim";
        String genre = "1";
        String control = "1";
        InputStream in1 = new ByteArrayInputStream(title.getBytes());
        InputStream in2 = new ByteArrayInputStream(genre.getBytes());
        InputStream in3 = new ByteArrayInputStream(control.getBytes());
        Game actual = new Game(in1, in2, in3);
        assertTrue((expected.title.equals(actual.title)) && (expected.genre.equals(actual.genre)) && (expected.control.equals(actual.control)));
    }
}
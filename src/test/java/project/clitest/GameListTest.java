package project.clitest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project.cli.Game;
import project.cli.GameList;

public class GameListTest {
    String game = "Skyrim";
    String genre = "RPG";
    String control = "First Person";
    Boolean started = false;
    Game gameobj = new Game(game, genre, control, started);

    @Test
    public void TestAdd(){
        GameList test = new GameList();
        test.testAdd(gameobj);
        assertTrue(test.gamelist.contains(gameobj));
    }

    @Test
    public void TestRemove(){
        GameList test = new GameList();
        test.testAdd(gameobj);
        test.remove(game);
        assertFalse(test.gamelist.contains(gameobj));
    }
}
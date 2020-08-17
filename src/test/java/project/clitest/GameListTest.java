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
    Game gameobj = new Game(game, genre, control);

    @Test
    public void TestAdd(){
        GameList test = new GameList();
        test.add(gameobj);
        assertTrue(test.gamelist.contains(gameobj));
    }

    @Test
    public void TestRemove(){
        GameList test = new GameList();
        test.add(gameobj);
        test.remove(game);
        assertFalse(test.gamelist.contains(gameobj));
    }

    @Test
    public void testEquals(){
        GameList list1 = new GameList();
        GameList list2 = new GameList();
        list1.add(gameobj);
        list2.add(gameobj);
        assertTrue(list1.equals(list2));
    }
}
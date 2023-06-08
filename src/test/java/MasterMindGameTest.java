

import org.example.MasterMindGame;

import org.example.NotValidEntryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MasterMindGameTest {

    @Test()
    public void secret_and_suppositions_must_not_be_null() {
       Assertions.assertThrows(NotValidEntryException.class, () -> {
           new MasterMindGame().evaluate(null, null);
       });

    }

    @Test()
    public void secret_must_not_be_null()  {
        Assertions.assertThrows(NotValidEntryException.class, () -> {
            new MasterMindGame().evaluate(null, List.of("blue"));
        });

    }

    @Test()
    public void suppositions_must_not_be_null()  {
        Assertions.assertThrows(NotValidEntryException.class, () -> {
            new MasterMindGame().evaluate(List.of("blue"), null );
        });

    }

    @Test
    public void must_be_the_same_size() throws NotValidEntryException {

        var secret = List.of("red", "blue");
        var supposition = List.of("blue");

        var game = new MasterMindGame();
        var response = game.evaluate(secret, supposition);

        Assertions.assertTrue(response[0] == -1);
    }

    @Test
    public void must_return_one_well_placed_one_misplaced() throws NotValidEntryException {

        var secret = List.of("blue", "red", "green", "pink");
        var supposition = List.of("yellow", "red", "blue", "purple");

        var game = new MasterMindGame();
        var response = game.evaluate(secret, supposition);

        Assertions.assertTrue(response[0] == 1);
        Assertions.assertTrue(response[1] == 1);
    }

    @Test
    public void must_return_zero_well_placed_zero_misplaced() throws NotValidEntryException {

        var secret = List.of("blue");
        var supposition = List.of("red");

        var game = new MasterMindGame();
        var response = game.evaluate(secret, supposition);

        Assertions.assertTrue(response[0] == 0);
        Assertions.assertTrue(response[1] == 0);
    }

    @Test
    public void must_return_one_well_placed_zero_misplaced() throws NotValidEntryException {

        var secret = List.of("blue");
        var supposition = List.of("blue");

        var game = new MasterMindGame();
        var response = game.evaluate(secret, supposition);

        Assertions.assertTrue(response[0] == 1);
        Assertions.assertTrue(response[1] == 0);
    }

    @Test
    public void must_return_zero_well_placed_one_misplaced() throws NotValidEntryException {

        var secret = List.of("red", "yellow");
        var supposition = List.of("blue", "red");

        var game = new MasterMindGame();
        var response = game.evaluate(secret, supposition);

        Assertions.assertTrue(response[0] == 0);
        Assertions.assertTrue(response[1] == 1);
    }

}
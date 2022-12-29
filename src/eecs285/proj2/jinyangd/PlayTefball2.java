package eecs285.proj2.jinyangd; // replace with your uniqname

import eecs285.proj2.jinyangd.PlayingField;

import static java.lang.System.out;

/** This class provides a main method for playing a game of Tefball
 *  ("tef" = "t"wo "e"ighty "f"ive).
 *  @author Andrew M. Morgan
 *  @date 9/24/2012
 */
public class PlayTefball2 {
  public static void main(String args[]) {
    PlayingField theField; // The game field, which I will interface with
    int playerInd;          // These local variables are just to make the
    double startColumn;     // code easier to read so that the order and
    double startRow;        // meaning of the arguments to the "add..."
    double stopColumn;      // functions are easy to interpret.
    double stopRow;
    double throwToColumn;
    double throwToRow;
    double speed;
    double throwSpeed;
    double intermedColumn;
    double intermedRow;

    int numPlayers;
    int fieldWidth;
    int fieldHeight;

    // Print the welcome message and instantiate a new field
    out.println("Welcome to Tefball - enjoy the game");
    numPlayers = 4;
    fieldWidth = 16;
    fieldHeight = 12;
    theField = new PlayingField(numPlayers, fieldWidth, fieldHeight);

    // Now request the creation of some players on the field.
    playerInd = 0;
    startColumn = 8;
    startRow = 4;
    stopColumn = 8;
    stopRow = 1;
    throwToColumn = 10;
    throwToRow = 8;
    speed = 1;
    throwSpeed = 3;
    theField.addQuarterback(playerInd,
                            startColumn, startRow,
                            stopColumn, stopRow,
                            throwToColumn, throwToRow,
                            speed, throwSpeed);

    playerInd = 1;
    startColumn = 4;
    startRow = 4;
    intermedColumn = 2;
    intermedRow = 6;
    stopColumn = 4;
    stopRow = 8;
    speed = 1.4143;
    theField.addReceiver(playerInd,
                         startColumn, startRow,
                         intermedColumn, intermedRow,
                         stopColumn, stopRow,
                         speed);

    playerInd = 2;
    startColumn = 6;
    startRow = 5;
    speed = 1.4143;
    theField.addDefender(playerInd,
                         startColumn, startRow,
                         speed);

    playerInd = 3;
    startColumn = 12;
    startRow = 4;
    intermedColumn = 11;
    intermedRow = 6;
    stopColumn = 10;
    stopRow = 8;
    speed = 1;
    theField.addReceiver(playerInd,
                         startColumn, startRow,
                         intermedColumn, intermedRow,
                         stopColumn, stopRow,
                         speed);

    runGame(theField);
  }

  // Run the game, as long as the set up was all done properly,
  // otherwise output an error message.
  private static void runGame(PlayingField theField) {
    if (theField.checkIsValidGame()) {
      out.println("Game is properly set up - let's play!");
      GameResultEnum gameResult = theField.playBall();

      out.println("Game ends with: " + gameResult);
    } else {
      out.println("The game has not been set up properly!");
    }
  }
}

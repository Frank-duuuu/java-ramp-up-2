/**
 * EECS 285 Project 2 - simulation of Tefball game.
 *
 * See https://eecs285.github.io/p2-tefball/ for the specification.
 */

package eecs285.proj2.jinyangd; // replace with your uniqname

import java.util.ArrayList;

public class PlayingField {
  public int numPlayers;
  public int fieldWidth;
  public int fieldHeight;
  public ArrayList<Player> players = new ArrayList<>();
  public int quarterbackCount = 0;
  public int receiverCount = 0;
  public int defenderCount = 0;
  public int quarterbackIndex;
  public Ball ball;

  /**
   * Creates a PlayingField object.
   *
   * @param numPlayers  the number of players in the game
   * @param fieldWidth  the width of the playing field
   * @param fieldHeight  the height of the playing field
   */
  PlayingField(int numPlayers,
               int fieldWidth,
               int fieldHeight) {
    this.numPlayers = numPlayers;
    this.fieldWidth = fieldWidth;
    this.fieldHeight = fieldHeight;
  }

  /**
   * Adds a quarterback to the field.
   *
   * @param playerIndex  0-based index that determines when the player
   *                     will move in each turn
   * @param startColumn  the column of the player's starting position
   * @param startRow  the row of the player's starting position
   * @param stopColumn  the column of the player's stopping position
   * @param stopRow  the row of the player's stopping position
   * @param throwToColumn  the column of the location to throw the ball
   * @param throwToRow  the row of the location to throw the ball
   * @param speed  the speed at which the player moves
   * @param throwSpeed  the speed at which the ball moves once it is
   *                    thrown
   */
  void addQuarterback(int playerIndex,
                      double startColumn,
                      double startRow,
                      double stopColumn,
                      double stopRow,
                      double throwToColumn,
                      double throwToRow,
                      double speed,
                      double throwSpeed) {
    quarterbackIndex = players.size();
    players.add(
        new Quarterback(
            playerIndex, startColumn, startRow, stopColumn,stopRow,
            throwToColumn, throwToRow, speed, throwSpeed
        )
    );
    ball = new Ball(stopColumn, stopRow, throwToColumn, throwToRow, throwSpeed);
    quarterbackCount++;
  }

  /**
   * Adds a receiver to the field.
   *
   * @param playerIndex  0-based index that determines when the player
   *                     will move in each turn
   * @param startColumn  the column of the player's starting position
   * @param startRow  the row of the player's starting position
   * @param intermediateColumn  the column of the player's
   *                            intermediate destination
   * @param intermediateRow  the row of the player's intermediate
   *                         destination
   * @param stopColumn  the column of the player's final destination
   * @param stopRow  the row of the player's final destination
   * @param speed  the speed at which the player moves
   */
  void addReceiver(int playerIndex,
                   double startColumn,
                   double startRow,
                   double intermediateColumn,
                   double intermediateRow,
                   double stopColumn,
                   double stopRow,
                   double speed) {
    players.add(
        new Receiver(
            playerIndex, startColumn, startRow,
            intermediateColumn, intermediateRow, stopColumn, stopRow, speed
        )
    );
    receiverCount++;
  }

  /**
   * Adds a defender to the field.
   *
   * @param playerIndex  0-based index that determines when the player
   *                     will move in each turn
   * @param startColumn  the column of the player's starting position
   * @param startRow  the row of the player's starting position
   * @param speed  the speed at which the player moves
   */
  void addDefender(int playerIndex,
                   double startColumn,
                   double startRow,
                   double speed) {
    players.add(
        new Defender(playerIndex, startColumn, startRow, speed)
    );
    defenderCount++;
  }

  /**
   * Determines whether or not the game setup is valid.
   *
   * A valid game has a single quarterback and a player added to each
   * expected index.
   *
   * @return  whether or not the game is valid
   */
  boolean checkIsValidGame() {
    return quarterbackCount == 1 &&
          (quarterbackCount + receiverCount + defenderCount) == numPlayers;
  }

  /**
   * Runs the game simulation to completion, returning the result.
   *
   * Simulates turns until the game ends. A turn involves the ball
   * moving first, if it has been thrown, and then each player in turn
   * by index. If a game-ending event occurs during a turn (i.e. a
   * sack, interception, reception, or incompletion), returns with the
   * corresponding enum value. Otherwise, continues to simulate turns
   * until the game ends with one of those events.
   *
   * Note: a turn may not complete - if a game-ending event occurs,
   * the game ends immediately without the remaining players moving.
   *
   * @return  enum value corresponding to the result of the game
   */
  GameResultEnum playBall() {
    if (players.get(quarterbackIndex).isThrown) {
      ball.performMove();
    }
    for (Player player : players) {
      if (player instanceof Defender) {
        if (players.get(quarterbackIndex).isThrown) {
          ((Defender) player).stopColumn = ball.curColumn;
          ((Defender) player).stopRow = ball.curRow;
        }
        else {
          ((Defender) player).stopColumn = players.get(quarterbackIndex).curColumn;
          ((Defender) player).stopRow = players.get(quarterbackIndex).curRow;
        }
      }
      player.performMove();
    }
  }

}

/**
 * EECS 285 Project 2 - simulation of Tefball game.
 *
 * See https://eecs285.github.io/p2-tefball/ for the specification.
 */

package eecs285.proj2.jinyangd.<uniqname>; // replace with your uniqname

public class PlayingField {

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
    // your code here
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
    // your code here
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
    // your code here
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
    // your code here
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
    return false; // replace with your solution
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
    return GameResultEnum.ONGOING; // replace with your solution
  }

}

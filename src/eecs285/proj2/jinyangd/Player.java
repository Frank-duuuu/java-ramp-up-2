package eecs285.proj2.jinyangd;

public abstract class Player {
  public int playerIndex;
  public double startColumn;
  public double startRow;
  public double speed;
  public double curColumn;
  public double curRow;
  public boolean isThrown = false;
  Player(int playerIndex,
         double startColumn,
         double startRow,
         double speed) {
    this.playerIndex = playerIndex;
    this.startColumn = startColumn;
    this.startRow = startRow;
    this.speed = speed;
    this.curColumn = startColumn;
    this.curRow = startRow;
  }

  public abstract void performMove();
}


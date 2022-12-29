package eecs285.proj2.jinyangd;

public class Receiver extends Player {
  public double intermediateColumn;
  public double intermediateRow;
  public double stopColumn;
  public double stopRow;

  Receiver(int playerIndex,
           double startColumn,
           double startRow,
           double intermediateColumn,
           double intermediateRow,
           double stopColumn,
           double stopRow,
           double speed) {
    super(playerIndex, startColumn, startRow, speed);
    this.intermediateColumn = intermediateColumn;
    this.intermediateRow = intermediateRow;
    this.stopColumn = stopColumn;
    this.stopRow = stopRow;
  }

  @Override
  public void performMove() {
    return;
  }
}

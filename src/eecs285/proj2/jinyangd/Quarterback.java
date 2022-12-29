package eecs285.proj2.jinyangd;

public class Quarterback extends Player {
  public double stopColumn;
  public double stopRow;
  public double throwToColumn;
  public double throwToRow;
  public double throwSpeed;

  Quarterback(int playerIndex,
              double startColumn,
              double startRow,
              double stopColumn,
              double stopRow,
              double throwToColumn,
              double throwToRow,
              double speed,
              double throwSpeed) {
    super(playerIndex, startColumn, startRow, speed);
    this.stopColumn = stopColumn;
    this.stopRow = stopRow;
    this.throwToColumn = throwToColumn;
    this.throwToRow = throwToRow;
    this.throwSpeed = throwSpeed;
  }

  @Override
  public void performMove() {
    return;
  }
}

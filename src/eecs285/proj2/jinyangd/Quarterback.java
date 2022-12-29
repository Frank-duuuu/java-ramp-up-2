package eecs285.proj2.jinyangd;

public class Quarterback extends Player {
  public double stopColumn;
  public double stopRow;
  public double throwToColumn;
  public double throwToRow;
  public double throwSpeed;
  public double curColumn;
  public double curRow;

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
    this.curColumn = startColumn;
    this.curRow = startRow;
  }

  @Override
  public void performMove() {
    if (curColumn == stopColumn && curRow == stopRow) return;
    double dirColumn = stopColumn - curColumn;
    double dirRow = stopRow - curRow;
    double length = Math.sqrt(dirColumn * dirColumn + dirRow * dirRow);
    double dirColUnit = dirColumn / length;
    double dirRowUnit = dirRow / length;
    double stepColumn = dirColUnit * speed;
    double stepRow = dirRowUnit * speed;
    double tempColumn = curColumn + stepColumn;
    double tempRow = curRow + stepRow;
    if ((curColumn <= stopColumn && curRow <= stopRow) && 
        (tempColumn >= stopColumn && tempRow >= stopRow)) {
      curColumn = stopColumn;
      curRow = stopRow;
    }
    else if ((curColumn >= stopColumn && curRow >= stopRow) &&
             (tempColumn <= stopColumn && tempRow <= stopRow)) {
      curColumn = stopColumn;
      curRow = stopRow;
    }
    else if ((curColumn <= stopColumn && curRow >= stopRow) &&
             (tempColumn >= stopColumn && tempRow <= stopRow)) {
      curColumn = stopColumn;
      curRow = stopRow;
    }
    else if ((curColumn >= stopColumn && curRow <= stopRow) &&
             (tempColumn <= stopColumn && tempRow >= stopRow)) {
      curColumn = stopColumn;
      curRow = stopRow;
    }
    else {
      curColumn = tempColumn;
      curRow = tempRow;
    }
  }
}

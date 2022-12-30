package eecs285.proj2.jinyangd;

public class Ball {
  public double startColumn;
  public double startRow;
  public double stopColumn;
  public double stopRow;
  public double speed;
  public double curColumn;
  public double curRow;

  Ball(double startColumn, double startRow, double stopColumn, double stopRow, double speed) {
    this.startColumn = startColumn;
    this.startRow = startRow;
    this.stopColumn = stopColumn;
    this.stopRow = stopRow;
    this.speed = speed;
    this.curColumn = startColumn;
    this.curRow = startRow;
  }

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

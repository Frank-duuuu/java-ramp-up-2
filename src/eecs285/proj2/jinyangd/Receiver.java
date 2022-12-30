package eecs285.proj2.jinyangd;

public class Receiver extends Player {
  public double intermediateColumn;
  public double intermediateRow;
  public double stopColumn;
  public double stopRow;
  public boolean passedIntermediate = false;

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

  private boolean checkPassed(double destColumn, double destRow,
                           double tempColumn, double tempRow) {
    if ((curColumn <= destColumn && curRow <= destRow) &&
        (tempColumn >= destColumn && tempRow >= destRow)) {
      curColumn = destColumn;
      curRow = destRow;
      return true;
    }
    else if ((curColumn >= destColumn && curRow >= destRow) &&
        (tempColumn <= destColumn && tempRow <= destRow)) {
      curColumn = destColumn;
      curRow = destRow;
      return true;
    }
    else if ((curColumn <= destColumn && curRow >= destRow) &&
        (tempColumn >= destColumn && tempRow <= destRow)) {
      curColumn = destColumn;
      curRow = destRow;
      return true;
    }
    else if ((curColumn >= destColumn && curRow <= destRow) &&
        (tempColumn <= destColumn && tempRow >= destRow)) {
      curColumn = destColumn;
      curRow = destRow;
      return true;
    }
    else {
      curColumn = tempColumn;
      curRow = tempRow;
      return false;
    }
  }
  @Override
  public void performMove() {
    if (curColumn == stopColumn && curRow == stopRow) return;
    if (!passedIntermediate) {
      double dirColumn = intermediateColumn - curColumn;
      double dirRow = intermediateRow - curRow;
      double length = Math.sqrt(dirColumn * dirColumn + dirRow * dirRow);
      double dirColUnit = dirColumn / length;
      double dirRowUnit = dirRow / length;
      double stepColumn = dirColUnit * speed;
      double stepRow = dirRowUnit * speed;
      double tempColumn = curColumn + stepColumn;
      double tempRow = curRow + stepRow;
      if (checkPassed(intermediateColumn, intermediateRow, tempColumn, tempRow)) {
        passedIntermediate = true;
      }
      return;
    }
    double dirColumn = stopColumn - curColumn;
    double dirRow = stopRow - curRow;
    double length = Math.sqrt(dirColumn * dirColumn + dirRow * dirRow);
    double dirColUnit = dirColumn / length;
    double dirRowUnit = dirRow / length;
    double stepColumn = dirColUnit * speed;
    double stepRow = dirRowUnit * speed;
    double tempColumn = curColumn + stepColumn;
    double tempRow = curRow + stepRow;
    checkPassed(stopColumn, stopRow, tempColumn, tempRow);
  }
}

package eecs285.proj2.jinyangd;

public class Defender extends Player {
  Defender(int playerIndex,
           double startColumn,
           double startRow,
           double speed) {
    super(playerIndex, startColumn, startRow, speed);
  }

  @Override
  public void performMove() {
    return;
  }
}

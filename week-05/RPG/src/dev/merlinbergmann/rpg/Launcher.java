package dev.merlinbergmann.rpg;

import dev.merlinbergmann.rpg.Game;

public class Launcher {
  public static void main(String[] args) {
    Game game = new Game("LovingBudapest", 800, 800);
    game.start();
  }
}

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxes {

  public static void mainDraw(Graphics graphics){
    // create a square drawing function that takes 2 parameters:
    // the square size, and the fill color,
    // and draws a square of that size and color to the center of the canvas.
    // create a loop that fills the canvas with rainbow colored squares.

    // This defines a random start value of the rainbow. Each time the program runs, it will generate
    // a different rainbow!
    float startHue = (float)(Math.random());

    for (int i = 0; i < WIDTH; i += 2) {
      //This iterates through the hue component of the colors!
      drawRainbowBox(graphics, i, Color.getHSBColor(startHue + ((float) i / (float) WIDTH), 1, 1));
    }

  }

  private static void drawRainbowBox(Graphics graphics, int size, Color color) {
    graphics.setColor(color);
    graphics.drawRect(WIDTH / 2 - size / 2, HEIGHT / 2 - size / 2, size, size);
  }

  //    Don't touch the code below
  static int WIDTH = 1960;
  static int HEIGHT = 1080;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(WIDTH, HEIGHT));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }
  static class ImagePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);

    }
  }

}

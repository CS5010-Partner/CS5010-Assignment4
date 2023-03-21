package IME;

import IME.model.Image;
import IME.model.PPMModel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import javax.imageio.ImageIO;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static void printPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      System.out.println("File " + filename + " not found!");
      return;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    System.out.println("Width of image: " + width);
    int height = sc.nextInt();
    System.out.println("Height of image: " + height);
    int maxValue = sc.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Color of pixel (" + j + "," + i + "): " + r + "," + g + "," + b);
      }
    }
  }

  /**
   * Method to read in an image in the PPM Format.
   *
   * @param filename Path to the image file.
   * @return A new IME.model.Image object from the loaded image.
   */
  public static Image loadPPMImage(String filename) {
    Scanner sc;
    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      return null;
    }


    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s).append(System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    int[][] red = new int[width][height];

    int[][] green = new int[width][height];

    int[][] blue = new int[width][height];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        red[j][i] = r;
        green[j][i] = g;
        blue[j][i] = b;
      }
    }
    return new PPMModel.PPMImage(width, height, red, blue, green);
  }

  /**
   * Method to read in an image in the PPM Format.
   *
   * @param filename Path to the image file.
   * @return A new IME.model.Image object from the loaded image.
   */
  public static Image loadImage(String filename) throws IOException {

    BufferedImage buf = ImageIO.read(new File(filename));
    return readBufferedImage(buf);
  }

  /**
   * Method to write a PPMImage to disk.
   *
   * @param image    Name of the image to write to disk.
   * @param fileName Path to location to write the image.
   * @throws IOException If path is invalid.
   */
  public static void writeToPPMFile(Image image, String fileName) throws IOException {
    File ppmFile = new File(fileName);
    FileWriter ppmWriter = new FileWriter(fileName);
    ppmWriter.write("P3\n");
    ppmWriter.write(String.format("%d %d\n", image.getWidth(), image.getHeight()));
    ppmWriter.write("255\n");
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        ppmWriter.write(String.format("%d\n", image.getRedComponent()[j][i]));
        ppmWriter.write(String.format("%d\n", image.getGreenComponent()[j][i]));
        ppmWriter.write(String.format("%d\n", image.getBlueComponent()[j][i]));
      }
    }
    ppmWriter.close();
  }

  /**
   * Method to write a buffered image from an image.
   *
   * @param image IME.model.Image to be used to write buffered image.
   * @return The resulting buffered image.
   */
  public static BufferedImage writeBufferedImage(Image image) {
    BufferedImage buffImage = new BufferedImage(image.getWidth(), image.getHeight(),
            BufferedImage.TYPE_INT_RGB);
    int r;
    int g;
    int b;
    int pixel;
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        r = image.getRedComponent()[i][j];
        g = image.getGreenComponent()[i][j];
        b = image.getBlueComponent()[i][j];
        pixel = 0xFF000000 + (r << 16) + (g << 8) + b;
        buffImage.setRGB(i, j, pixel);
      }
    }
    return buffImage;
  }


  public static Image readBufferedImage(BufferedImage buf) {
    int height = buf.getHeight();
    int width = buf.getWidth();
    int [][] r = new int[width][height];
    int [][] g = new int[width][height];
    int [][] b = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int rgb = buf.getRGB(i,j);
        r[i][j] = rgb >>16 & 0xff;
        g[i][j] = rgb>>8 & 0xff;
        b[i][j] = rgb & 0xff;
      }
    }
    return new PPMModel.PPMImage(width,height,r,b,g);
  }

}


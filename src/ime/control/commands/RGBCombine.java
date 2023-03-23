package ime.control.commands;

import ime.model.Model;
import java.util.NoSuchElementException;

/**
 * An commands.RGBCombine command object.
 */
public class RGBCombine implements Command {

  String[] commands;

  /**
   * Constructor for a commands.RGBCombine command object.
   *
   * @param commands String array of commands for object.
   */
  public RGBCombine(String[] commands) {
    this.commands = commands;
  }

  /**
   * Method to have model m call its rgbCombine method.
   *
   * @param m A model.
   */
  @Override
  public void run(Model m) throws NoSuchElementException {
    if(commands.length != 4) {
      throw new IllegalArgumentException("Invalid number of arguments for command \"rgb-combine\". "
          + "4 required.");
    }
    String imageName = commands[0];
    String rImageName = commands[1];
    String gImageName = commands[2];
    String bImageName = commands[3];
    m.rgbCombine(imageName, rImageName, gImageName, bImageName);
  }
}
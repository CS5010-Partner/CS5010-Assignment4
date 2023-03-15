package IME.control.commands;

import IME.model.Model;
import java.io.IOException;

/**
 * An commands.RGBSplit command object.
 */
public class RGBSplit implements Command {

  String[] commands;

  /**
   * Constructor for an commands.RGBSplit command object.
   *
   * @param commands String array of commands for object.
   */
  public RGBSplit(String[] commands) {
    this.commands = commands;
  }

  /**
   * Method to have model m run its rgbSplit method.
   *
   * @param m A model.
   */
  @Override
  public void run(Model m) throws IOException {
    String imageName = commands[1];
    String newRImageName = commands[2];
    String newGImageName = commands[3];
    String newBImageName = commands[4];
    m.rgbSplit(imageName, newRImageName, newGImageName, newBImageName);
  }
}
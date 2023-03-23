package ime.control.commands;

import ime.model.Model;
import java.util.NoSuchElementException;

/**
 * A commands.Greyscale command object.
 */
public class Greyscale implements Command {

  String[] commands;

  /**
   * Constructor for a GreyScale command object.
   *
   * @param commands String array of commands for object.
   */
  public Greyscale(String[] commands) {
    this.commands = commands;
  }

  /**
   * Method to have model m run its greyscale method.
   *
   * @param m A model.
   */
  @Override
  public void run(Model m) throws NoSuchElementException {
    if(commands.length != 3) {
      throw new IllegalArgumentException("Invalid number of arguments for command \"greyscale\"."
          + " 4 required.");
    }
    String greyScaleComponent = commands[0];
    String currentImageName = commands[1];
    String destImageName = commands[2];
    m.greyscale(greyScaleComponent, currentImageName, destImageName);

  }
}
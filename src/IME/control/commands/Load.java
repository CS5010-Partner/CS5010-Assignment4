package IME.control.commands;

import IME.model.Model;
import java.io.FileNotFoundException;

/**
 * A commands.Load command object.
 */
public class Load implements Command {

  String[] commands;

  /**
   * Constructor for a commands.Load command object.
   *
   * @param commands String array of commands for the object.
   */
  public Load(String[] commands) {
    this.commands = commands;
  }

  /**
   * Method to have the model m run its loadImage method.
   *
   * @param m A model.
   */
  @Override
  public void run(Model m) throws FileNotFoundException {
    String loadImagePath = commands[1];
    String loadImageName = commands[2];
    m.loadImage(loadImagePath, loadImageName);
  }
}
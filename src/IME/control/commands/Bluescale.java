package IME.control.commands;

import IME.model.Model;

/**
 * Class for a commands.Bluescale commands.Command object.
 */
public class Bluescale implements Command {

  String[] commands;

  /**
   * Constructor for a commands.Bluescale command object.
   *
   * @param commands String array of commands for object.
   */
  public Bluescale(String[] commands) {
    this.commands = commands;
  }

  /**
   * Method to have model m call its getBlueComponent method.
   *
   * @param m A model.
   */
  @Override
  public void run(Model m) {
    String imageName = commands[1];
    String newImageName = commands[2];
    m.getBlueComponent(imageName, newImageName);

  }
}
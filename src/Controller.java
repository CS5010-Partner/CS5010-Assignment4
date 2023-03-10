import java.io.IOException;

/**
 * Interface for controller objects for the MVC model of this program.
 */
public interface Controller {

  /**
   * Run method for the program. Takes in input, parses input and calls methods to instruct view
   * and model.
   *
   * @param currentModel Current model that the controller is communicating with.
   */
  void run(Model currentModel) throws IOException;

  /**
   * Method to instruct model to execute all other commands but load and save.
   * Called from run method.
   *
   * @param commands Array of strings that are the current commands.
   * @return 0 for failure, all other numbers for success.
   */
  void executeCommands(String[] commands, Model currentModel) throws IOException;

}

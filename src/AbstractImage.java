public abstract class AbstractImage implements Image {
  protected final int height;
  protected final int width;

  protected final int[][] redComponent;

  protected final int[][] greenComponent;

  protected final int[][] blueComponent;

  public AbstractImage(int width, int height, int[][] red,
                       int[][] blue, int[][] green) {
    this.height = height;
    this.width = width;
    this.redComponent = red;
    this.greenComponent = green;
    this.blueComponent = blue;
  }

  /**
   * Method to return the red component of the PPMImage objects rgb.
   *
   * @return A matrix representing the red component of the PPMImage.
   */
  @Override
  public int[][] getRedComponent() {
    return redComponent;
  }

  /**
   * Method to return the green component of the PPMImage objects rgb.
   *
   * @return A matrix representing the green component of the PPMImage.
   */
  @Override
  public int[][] getGreenComponent() {
    return greenComponent;
  }

  /**
   * Method to return the blue component of the PPMImage objects rgb.
   *
   * @return A matrix representing the blue component of the PPMImage.
   */
  @Override
  public int[][] getBlueComponent() {
    return blueComponent;
  }

  /**
   * Method to return the height of the PPMImage in pixels.
   *
   * @return An integer representing the height of the PPMImage in pixels.
   */
  @Override
  public int getHeight() {
    return height;
  }

  /**
   * Method to return the width of the PPMImage in pixels.
   *
   * @return An integer representing the width of the PPMImage in pixels.
   */
  @Override
  public int getWidth() {
    return width;
  }

  /**
   * Method to determine if two PPMImage objects are equal.
   *
   * @param o An object to check if equal to {@code this} PPMImage.
   * @return True if equal, false if otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof PPMModel.PPMImage)) {
      return false;
    }
    PPMModel.PPMImage c = (PPMModel.PPMImage) o;

    return c.getWidth() == this.getWidth() && c.getHeight() == this.getHeight() &&
            c.blueComponent.equals(blueComponent) && c.greenComponent.equals(greenComponent) &&
            c.redComponent.equals(redComponent);

  }

  /**
   * Method to get a hashCode for a PPMImage.
   *
   * @return An integer hashcode for the object.
   */
  @Override
  public int hashCode() {
    return 67499 * this.getWidth() * this.getHeight();
  }
}

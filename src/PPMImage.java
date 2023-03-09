import java.util.Arrays;

public class PPMImage implements Image {

  private final int height;
  private final int width;

  private final int[][] redComponent;

  private final int[][] greenComponent;

  private final int[][] blueComponent;


  public PPMImage(int width, int height, int[][] red,
                  int[][] blue, int[][] green) {
    this.height = height;
    this.width = width;
    this.redComponent = red;
    this.greenComponent = green;
    this.blueComponent = blue;
  }


  @Override
  public boolean isSingleChannel() {
    return Arrays.equals(redComponent, greenComponent)
            && Arrays.equals(redComponent, blueComponent);
  }

  @Override
  public int[][] getRedComponent() {
    return redComponent;
  }

  @Override
  public int[][] getGreenComponent() {
    return greenComponent;
  }

  @Override
  public int[][] getBlueComponent() {
    return blueComponent;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public Image flipHorizontal() {
    int[][] red = flipArrayHorizontal(redComponent);
    int[][] green = flipArrayHorizontal(greenComponent);
    int[][] blue = flipArrayHorizontal(blueComponent);
    return new PPMImage(width, height, red, blue, green);
  }

  private int[][] flipArrayHorizontal(int[][] arr) {
    int temp;
    int[][] flippedH = new int[width][height];
    for (int i = 0; i < getHeight(); i++) {
      for (int j = 0; j < getWidth() / 2; j++) {
        temp = arr[getWidth() - j - 1][i];
        flippedH[getWidth() - j - 1][i] = arr[j][i];
        flippedH[j][i] = temp;
      }
    }

    return flippedH;
  }

  @Override
  public Image flipVertical() {
    int[][] red = flipArrayVertical(redComponent);
    int[][] green = flipArrayVertical(greenComponent);
    int[][] blue = flipArrayVertical(blueComponent);
    return new PPMImage(width, height, red, blue, green);
  }

  private int[][] flipArrayVertical(int[][] arr) {
    int temp;
    int[][] flippedV = new int[width][height];
    for (int i = 0; i < getWidth(); i++) {
      for (int j = 0; j < getHeight() / 2; j++) {
        temp = arr[i][j];
        flippedV[i][j] = arr[i][getHeight() - 1 - j];
        flippedV[i][getHeight() - 1 - j] = temp;
      }
    }
    return flippedV;
  }


  @Override
  public Image getValueImage() {
    int[][] value = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int redValue = redComponent[i][j];
        int greenValue = greenComponent[i][j];
        int blueValue = blueComponent[i][j];
        int max = Math.max(redValue, greenValue);
        max = Math.max(max, blueValue);
        value[i][j] = max;
      }
    }
    return new PPMImage(width, height, value, value, value);
  }

  @Override
  public Image getIntensityImage() {
    int[][] intensity = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int redValue = redComponent[i][j];
        int greenValue = greenComponent[i][j];
        int blueValue = blueComponent[i][j];
        int intensityValue = (int) Math.ceil((double) (redValue + greenValue + blueValue) / 3);
        if (intensityValue > 255) {
          intensityValue = 255;
        } else if (intensityValue < 0) {
          intensityValue = 0;
        }
        intensity[i][j] = intensityValue;
      }
    }
    return new PPMImage(width, height, intensity, intensity, intensity);
  }

  @Override
  public Image getLumaImage() {
    int[][] luma = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int redValue = redComponent[i][j];
        int greenValue = greenComponent[i][j];
        int blueValue = blueComponent[i][j];
        int lumaValue = (int) Math.ceil((double) 0.2126 * redValue + 0.7152 * greenValue + 0.0722 * blueValue);
        if (lumaValue > 255) {
          lumaValue = 255;
        } else if (lumaValue < 0) {
          lumaValue = 0;
        }
        luma[i][j] = lumaValue;
      }
    }
    return new PPMImage(width, height, luma, luma, luma);
  }

  @Override
  public Image brighten(int scale) {
    int[][] red = brightenArray(redComponent, scale);
    int[][] green = brightenArray(greenComponent, scale);
    int[][] blue = brightenArray(blueComponent, scale);
    return new PPMImage(width, height, red, blue, green);
  }

  private int[][] brightenArray(int[][] arr, int scale) {
    int[][] brightened = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int val = arr[i][j] + scale;
        if (val > 255) {
          val = 255;
        } else if (val < 0) {
          val = 0;
        }
        brightened[i][j] = val;
      }
    }
    return brightened;
  }


  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof PPMImage)) {
      return false;
    }
    PPMImage c = (PPMImage) o;

    return c.getWidth() == this.getWidth() && c.getHeight() == this.getHeight() &&
            c.blueComponent.equals(blueComponent) && c.greenComponent.equals(greenComponent) &&
            c.redComponent.equals(redComponent);

  }

  @Override
  public int hashCode() {
    return 67499 * this.getWidth() * this.getHeight();
  }


}

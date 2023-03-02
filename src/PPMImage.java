/**
 * Class for manipulating a .ppm image file.
 */
public class PPMImage implements Image {

  private final String name;

  private final int width;

  private final int height;

  private final int[][] redComponent;

  private final int[][] greenComponent;

  private final int[][] blueComponent;

  public PPMImage(String name,int width, int height, int[][] r, int[][] g, int[][] b) {
    this.name = name;
    this.redComponent = r;
    this.greenComponent = g;
    this.blueComponent = b;
    this.width = width;
    this.height = height;
  }

  @Override
  public Image getRedComponentImage() {
    int [][] b = new int[width][height];
    int [][] g = new int[width][height];
    for(int i=0; i < getWidth();i++) {
      for(int j=0; j < getHeight();j++) {
        int val = redComponent[i][j];
        b[i][j] = val;
        g[i][j] = val;
      }
    }

    return new PPMImage(name,width,height,redComponent,g,b);
  }

  @Override
  public Image getGreenComponentImage() {
    return null;
  }

  @Override
  public Image getBlueComponentImage() {
    return null;
  }


  public int getRedAtIndex(int i, int j) {
    return redComponent[i][j];
  }

  public int getBlueAtIndex(int i, int j) {
    return blueComponent[i][j];
  }

  public int getGreenAtIndex(int i, int j) {
    return greenComponent[i][j];
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }
}

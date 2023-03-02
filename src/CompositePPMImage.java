public class CompositePPMImage extends AbstractPPMImage{

    private final SimplePPMImage redComponent;

    private final SimplePPMImage greenComponent;

    private final SimplePPMImage blueComponent;


    public CompositePPMImage(String name, int width, int height, SimplePPMImage red,
                             SimplePPMImage blue, SimplePPMImage green){
        super(name, width, height);
        this.redComponent = red;
        this.greenComponent = green;
        this.blueComponent = blue;
    }


    @Override
    public boolean isCompositePPMImage(){
        return true;
    }

    @Override
    public Image getRedscaleImage() {
        return this.redComponent;
    }

    @Override
    public Image getGreenscaleImage(){
      return this.greenComponent;
    }


    @Override
    public Image getBluescaleImage() {
        return this.blueComponent;
    }


    public int getRedAtIndex(int i, int j) {
        return redComponent.getIndex(i, j);
    }

    public int getBlueAtIndex(int i, int j) {
        return blueComponent.getIndex(i, j);
    }

    public int getGreenAtIndex(int i, int j) {
        return greenComponent.getIndex(i, j);
    }


    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }

        if(!(o instanceof CompositePPMImage)){
            return false;
        }

        CompositePPMImage c = (CompositePPMImage) o;

        if(c.getWidth() == this.getWidth() && c.getHeight() == this.getHeight() &&
                c.blueComponent.equals(blueComponent) && c.greenComponent.equals(greenComponent) &&
                c.redComponent.equals(redComponent)){
            return true;
        }

        return false;

    }







}


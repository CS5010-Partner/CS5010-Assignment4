import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModelControllerTest {


  @Test
  public void testLoadPPMImage() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("load images/koala.ppm koala");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 3390));
    assertEquals("loadPPMImage: imagePath = images/koala.ppm " +
            "newImageName = koala\n", log.toString());
    assertEquals("3390\n3390\n", out.toString());

  }

  @Test
  public void testSavePPMImage() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("save images/koala-brighter.ppm koala-brighter");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 4537));
    assertEquals("savePPMImage: imagePath = images/koala-brighter.ppm " +
            "imageName = koala-brighter\n", log.toString());
    assertEquals("4537\n4537\n", out.toString());
  }

  @Test
  public void testFlipHorizontal() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("horizontal-flip koala-vertical koala-vertical-horizontal");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 7362));
    assertEquals("flipHorizontal: currentImageName = koala-vertical " +
            "newImageName = koala-vertical-horizontal\n", log.toString());
    assertEquals("7362\n7362\n", out.toString());
  }




  @Test
  public void testFlipVertical() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("vertical-flip koala koala-vertical");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 999));
    assertEquals("flipVertical: currentImageName = koala " +
            "newImageName = koala-vertical\n", log.toString());
    assertEquals("999\n999\n", out.toString());
  }

  @Test
  public void testValueImage() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("value koala koala-value");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 1432));
    assertEquals("getValueImage: currentImageName = koala " +
            "newImageName = koala-value\n", log.toString());
    assertEquals("1432\n1432\n", out.toString());
  }

  @Test
  public void testIntensityImage() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("intensity koala koala-intensity");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 33332));
    assertEquals("getIntensityImage: currentImageName = koala " +
            "newImageName = koala-intensity\n", log.toString());
    assertEquals("33332\n33332\n", out.toString());
  }


  @Test
  public void testLumaImage() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("luma koala koala-luma");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 9191));
    assertEquals("getLumaImage: currentImageName = koala " +
            "newImageName = koala-luma\n", log.toString());
    assertEquals("9191\n9191\n", out.toString());
  }

  @Test
  public void testBrighten() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("brighten 50 koala koala-brighten");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 34342));
    assertEquals("brighten: currentImageName = koala " +
            "newImageName = koala-brighten scale = 50\n", log.toString());
    assertEquals("34342\n34342\n", out.toString());
  }

  @Test
  public void testRGBSplit() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rgb-split koala koala-red koala-green koala-blue");
    ControllerImp controllerTest = new Controller(in, out);
    StringBuilder log = new StringBuilder();
    controllerTest.run(new MockModel(log, 6767));
    assertEquals("rgbSplit: currentImageName = koala " +
            "redImageName = koala-red greenImageName = koala-green blueImageName = koala-blue\n", log.toString());
    assertEquals("6767\n6767\n", out.toString());
  }

}
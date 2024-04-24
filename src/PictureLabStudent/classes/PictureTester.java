package PictureLabStudent.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("temple.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testFixUnderwater()
  {
    Picture fish = new Picture("water.jpg");
    fish.explore();
    fish.fixUnderwater();
    fish.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testBetterEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.betterEdgeDetection(15);
    swan.explore();
  }

  public static void testMirrorHorizontal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontal();
    beach.explore();
  }
  public static void testMirrorVerticalRightToLeft()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorVerticalRightToLeft();
    beach.explore();
  }

  public static void testMirrorHorizontalBotToTop()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontalBotToTop();
    beach.explore();
  }

  public static void testMirrorDiagonal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }

  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGull()
  {
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorGull();
    seagull.explore();
  }

  public static void testCopy()
  {
    Picture canvas = new Picture("640x480.jpg");
    Picture swan = new Picture("swan.jpg");
    canvas.copy(swan, 0, 0, 240, 240);
    canvas.copy(swan, 240, 240, 480, 480);
    canvas.explore();
  };

  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    testZeroBlue();
    testFixUnderwater();
    testMirrorVertical();
    testMirrorTemple();
    testEdgeDetection();
    testBetterEdgeDetection();
    testMirrorHorizontal();
    testMirrorVerticalRightToLeft();
    testMirrorHorizontalBotToTop();
    testMirrorDiagonal();
    testMirrorArms();
    testMirrorGull();
    testCopy();
    testMyCollage();
  }
}
package PictureLabStudent.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }

  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }

  public void grayScale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        double avg = pixelObj.getBlue()+pixelObj.getGreen()+pixelObj.getRed();
        avg/=3;
        pixelObj.setBlue((int) avg);
        pixelObj.setRed((int) avg);
        pixelObj.setGreen((int) avg);
      }
    }
  }

  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if(pixelObj.getRed()>22){
          pixelObj.setRed(0);
          pixelObj.setGreen(pixelObj.getGreen()-50);
        }else{
          pixelObj.setRed(pixelObj.getRed()+25);
        }
      }
    }
  }


  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    int width = pixels[0].length;

    for (int col = 0; col < width; col++)//int col = 0; col < height / 2; col++
    {
      for (int row = 0; row < pixels.length; row++)//int row = 0; row < pixels.length; row++
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1- row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    int width = pixels[0].length;

    for (int col = 0; col < width; col++)//int col = 0; col < height / 2; col++
    {
      for (int row = 0; row < pixels.length; row++)//int row = 0; row < pixels.length; row++
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1- row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }

  public void mirrorDiagonal()
  {
    mirrorHorizontalBotToTop();
    mirrorVerticalRightToLeft();
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }

    /** Mirror just part of a picture of a snowman */
    public void mirrorArms()
    {
      int mirrorPoint = 190;
      Pixel topPixel = null;
      Pixel bottomPixel = null;
      int count = 0;
      Pixel[][] pixels = this.getPixels2D();
      
      for (int col = 88; col < 300; col++)
      {
        for (int row = 158; row < mirrorPoint; row++)
        {
          topPixel = pixels[row][col];      
          bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
          bottomPixel.setColor(topPixel.getColor());
          count++;
        }
      }
    }

    public void mirrorGull()
    {
      int mirrorPoint = 350;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int count = 0;
      Pixel[][] pixels = this.getPixels2D();
      
      for (int row = 230; row < 330; row++)
      {
        for (int col = 230; col < mirrorPoint; col++)
        {
          leftPixel = pixels[row][col];      
          rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
          rightPixel.setColor(leftPixel.getColor());
          count++;
        }
      }
    }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void copy(Picture fromPic, int startRow, int startCol, int endRow, int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; fromRow < endRow && toRow < toPixels.length; fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; fromCol < endCol && toCol < toPixels[0].length; fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  public void myCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.copy(new Picture("flower1.jpg"), 0, 0, 100, 100);
    canvas.copy(new Picture("robot.jpg"), 0, 100);
    canvas.copy(new Picture("swan.jpg"), 100, 0);
    canvas.explore();
  };
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel belowPixel = null; // Added line
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color belowColor = null; // Added line
    for (int row = 0; row < pixels.length - 1; row++) // Modified line
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        belowPixel = pixels[row+1][col]; // Added line
        rightColor = rightPixel.getColor();
        belowColor = belowPixel.getColor(); // Added line
        if (leftPixel.colorDistance(rightColor) > edgeDist || leftPixel.colorDistance(belowColor) > edgeDist) // Modified line
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
    public void betterEdgeDetection(int edgeDist){
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 0; row < pixels.length - 1; row++) {
        for (int col = 0; col < pixels[0].length - 1; col++) {
          Pixel currentPixel = pixels[row][col];
          Pixel rightPixel = pixels[row][col + 1];
          Pixel belowPixel = pixels[row + 1][col];
          
          double currentIntensity = currentPixel.getAverage();
          double rightIntensity = rightPixel.getAverage();
          double belowIntensity = belowPixel.getAverage();
          
          double intensityDiffRight = Math.abs(currentIntensity - rightIntensity);
          double intensityDiffBelow = Math.abs(currentIntensity - belowIntensity);
          
          if (intensityDiffRight > edgeDist || intensityDiffBelow > edgeDist) {
            currentPixel.setColor(Color.BLACK);
          } else {
            currentPixel.setColor(Color.WHITE);
          }
        }
      }
    }
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this

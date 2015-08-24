import acm.graphics.*;
import acm.program.*;
import java.util.*;

public class GrayScale extends GraphicsProgram{
 
 public void run(){
 GImage img = new GImage("betu.JPG");
 GImage grayImg = createGrayImage(img);

 img.scale(0.25);
 add(img, 10, 50);

 grayImg.scale(0.25);
 add(grayImg, 600, 50);
 }

 private GImage createGrayImage(GImage image){
  int[][] array = image.getPixelArray();

  int height = array.length;
  int width  = array[0].length;

  for(int i = 0; i < height; i++){
   for(int j = 0; j < width; j++){
     int pixel = array[i][j];

     int r = image.getRed(pixel);
     int g = image.getGreen(pixel);
     int b = image.getBlue(pixel);

     int xx = computeLuminiousity(r, g, b);
   
     array[i][j] = GImage.createRGBPixel(xx, xx, xx);
   }
  }
  return new GImage(array);
 }

 private int computeLuminiousity(int r, int g, int b){
  return GMath.round(0.299 * r + 0.587 * g + 0.114 * b);
 }
}

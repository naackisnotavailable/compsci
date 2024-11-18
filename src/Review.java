package ReviewStudentCode;

import java.util.*;
import java.io.File;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  public static String fakeReview(String filename){
    String str = textToString(filename);
    String[] wordArray = str.split(" ");
    for(int i=0; i< wordArray.length; i++){
      String x = wordArray[i];
      x = x.strip();
      if(x.startsWith("*")){
        x=removePunctuation(x);
        double sVal = sentimentVal(x);
        String r;
        if(sVal>0){
          r = randomPositiveAdj();
        }else{
          r = randomNegativeAdj();
        }
        wordArray[i] = r;
      }

    }
    String res = "";
    for(String x: wordArray){
      res=res.concat(x+" ");
    }
    return res;
  }
  public static void sortAdj() {
    String p = "";
    String n = "";
    for (Map.Entry<String, Double> x : sentiment.entrySet()) {
      if (x.getValue() > 0) {
        p = p.concat(x.getKey()+"\n");
      } else{
        n = n.concat(x.getKey()+"\n");
      }
    }
    try {
      FileWriter pFile = new FileWriter("C:\\Users\\nick7\\IdeaProjects\\csci\\src\\ReviewStudentCode\\positiveAdjectives.txt");
      FileWriter nFile = new FileWriter("C:\\Users\\nick7\\IdeaProjects\\csci\\src\\ReviewStudentCode\\negativeAdjectives.txt");
      pFile.write(p);
      nFile.write(n);
      pFile.close();
      nFile.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  public static int starRating(String filename){
    double tSent = totalSentiment(filename);
    if(tSent>30) {
      return 5;
    }else if(tSent>20) {
      return 4;
    }else if(tSent>10) {
      return 3;
    }else if(tSent>5) {
      return 2;
    }else if(tSent>0) {
      return 1;
    }else{
      return 0;
    }
  }
  public static double totalSentiment(String filename){
    String str = textToString(filename);
    String[] wordArray = str.split(" ");
    double val = 0;
    for(String x: wordArray){
      x=removePunctuation(x);
      x = x.strip();
      if(x.startsWith("*")){
        x=x.substring(1, x.length());
      }
      double sVal = sentimentVal(x);
      val+= sVal;

    }
    return val;
  }

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();


  private static final String SPACE = " ";

  static{
    try {
      Scanner input = new Scanner(new File("C:\\Users\\nick7\\IdeaProjects\\csci\\src\\ReviewStudentCode\\cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }


  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("C:\\Users\\nick7\\IdeaProjects\\csci\\src\\ReviewStudentCode\\positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        //System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }

  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("C:\\Users\\nick7\\IdeaProjects\\csci\\src\\ReviewStudentCode\\negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }
  }

  /**
   * returns a string containing all of the text in fileName (including punctuation),
   * with words separated by a single space
   */
  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isLetterOrDigit(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isLetterOrDigit(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
}


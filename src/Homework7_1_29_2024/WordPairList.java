package Homework7_1_29_2024;

import java.util.ArrayList;

public class WordPairList {
    private ArrayList<WordPair> wordPairs;

    public WordPairList(String[] words) {
        wordPairs = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                WordPair pair = new WordPair(words[i], words[j]);
                wordPairs.add(pair);
            }
        }
    }

    /**
     * Returns the number of word pairs in the list that have the same word1 and word2.
     *
     * @return the number of matching word pairs
     */
    public int numMatches() {
        int count = 0;
        for (WordPair pair : wordPairs) {
            if (pair.getWord1().equals(pair.getWord2())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a string representation of the word pairs in the WordPairList.
     * The word pairs are formatted as "word1-word2" and separated by a space.
     *
     * @return a string representation of the word pairs
     */
    public String getWordPairs(){
        String result = "";
        for (WordPair pair : wordPairs) {
            result += pair.getWord1() + "-" + pair.getWord2() + " ";
        }
        return result;
    }

    
    
}

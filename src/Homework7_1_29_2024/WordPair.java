package Homework7_1_29_2024;

public class WordPair {
    private String[] words;

    public WordPair(String word1, String word2) {
        words = new String[2];
        words[0] = word1;
        words[1] = word2;
    }

    public String getWord1() {
        return words[0];
    }

    public String getWord2() {
        return words[1];
    }
}

package Elevens;

import java.util.ArrayList;
import java.util.Arrays;

public class Shuffle {
    public static int[] perfectShuffle(int[] arr) {
        // Shuffles the deck by moving the first half to the even index positions and the second half to the odd index positions
        ArrayList<Integer> shuffled = new ArrayList<Integer>();
        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            shuffled.add(arr[i]);
            shuffled.add(arr[i + mid]);
        }
        if (arr.length % 2 != 0) {
            shuffled.add(arr[arr.length - 1]);
        }
        
        int[] shuffledArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            shuffledArr[i] = shuffled.get(i);
        }
        return shuffledArr;
    }
    public static ArrayList<Card> perfectShuffle(Deck deck){
        //shuffle deck with perfect shuffle
        ArrayList<Card> shuffled = new ArrayList<Card>();
        int mid = deck.size() / 2;
        for (int i = 0; i < mid; i++) {
            shuffled.add(deck.cards.get(i));
            shuffled.add(deck.cards.get(i + mid));
        }
        if (deck.size() % 2 != 0) {
            shuffled.add(deck.cards.get(deck.size() - 1));
        }
        return shuffled;

    }

        public static int[] selectionShuffle(int[] arr) {
            for (int i = arr.length - 1; i > 0; i--) {
                int j = (int) (Math.random() * (i + 1));
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return arr;
        }

        public static ArrayList<Card> selectionShuffle(Deck deck){
            for (int i = deck.size() - 1; i > 0; i--) {
                int j = (int) (Math.random() * (i + 1));
                Card temp = deck.cards.get(i);
                deck.cards.set(i, deck.cards.get(j));
                deck.cards.set(j, temp);
            }
            return deck.cards;
        }

        public static String flip(){
            return Math.random() <= 0.6666666666666666 ? "heads" : "tails";
        }

        public static boolean arePermutations(int[] arr1, int[] arr2) {
            if (arr1.length != arr2.length) {
                return false;
            }
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6};
            System.out.println("Perfect Shuffle: " + Arrays.toString(perfectShuffle(arr)));
            System.out.println("Selection Shuffle: " + Arrays.toString(selectionShuffle(arr)));
            System.out.println("Flip: " + flip());
        }


}

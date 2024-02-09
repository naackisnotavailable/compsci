package Elevens;

public class DeckTest {
    public static void main(String[] args) {
        String[] ranks1 = {"A", "B", "C"};
        String[] suits1 = {"Giraffes", "Lions"};
        int[] pointValues1 = {2, 1, 6};

        Deck deck1 = new Deck(ranks1, suits1, pointValues1);

        String[] ranks2 = {"D", "E", "F"};
        String[] suits2 = {"Giraffes", "Lions"};
        int[] pointValues2 = {3, 2, 7};

        Deck deck2 = new Deck(ranks2, suits2, pointValues2);

        String[] ranks3 = {"G", "H", "I"};
        String[] suits3 = {"Giraffes", "Lions"};
        int[] pointValues3 = {4, 3, 8};

        Deck deck3 = new Deck(ranks3, suits3, pointValues3);

        System.out.println("Deck 1 is empty: " + deck1.isEmpty());
        System.out.println("Deck 1 size: " + deck1.size());
        System.out.println("Deck 1: " + deck1.toString());
        System.out.println("Deck 1 dealt card: " + deck1.deal());

        System.out.println("Deck 2 is empty: " + deck2.isEmpty());
        System.out.println("Deck 2 size: " + deck2.size());
        System.out.println("Deck 2: " + deck2.toString());
        System.out.println("Deck 2 dealt card: " + deck2.deal());

        System.out.println("Deck 3 is empty: " + deck3.isEmpty());
        System.out.println("Deck 3 size: " + deck3.size());
        System.out.println("Deck 3: " + deck3.toString());
        System.out.println("Deck 3 dealt card: " + deck3.deal());
        System.out.println("Deck 3 dealt card: " + deck3.deal());
    }

    
    
}

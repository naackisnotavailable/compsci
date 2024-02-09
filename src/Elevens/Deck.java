package Elevens;

import java.util.ArrayList;

public class Deck {
    int size;
    public ArrayList<Card> cards;
    public Deck(String[] ranks, String[] suits, int[] pointValues) {
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cards.add(new Card(ranks[i], suits[j], pointValues[i]));
            }
        }
        size = size();
        cards = Shuffle.selectionShuffle(this);
    }

    
    public boolean isEmpty() {
        return this.cards.size() == 0;
    }

    public int size() {
        return this.cards.size();
    }

    public String toString(){
        String result = "";
        for (Card card : cards) {
            result += card.toString() + "\n";
        }
        return result;

}

    public Card deal() {
        if (isEmpty()) {
            return null;
        }
        Card card = this.cards.get(size - 1);
        size-=1;
        return card;
    }
}

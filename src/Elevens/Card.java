package Elevens;

public class Card {
    private String rank;
    private String suit;
    private int pointValue;

    public Card(String rank, String suit, int pointValue) {
        this.rank = rank;
        this.suit = suit;
        this.pointValue = pointValue;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getPointValue() {
        return pointValue;
    }

    public boolean matches(Card otherCard) {
        return this.rank.equals(otherCard.getRank()) && this.suit.equals(otherCard.getSuit()) && this.pointValue == otherCard.getPointValue();
    }

    public String toString() {
        return rank + " of " + suit + " (point value = " + pointValue + ")";
    }

    

}

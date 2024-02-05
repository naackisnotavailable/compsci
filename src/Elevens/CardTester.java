package Elevens;

public class CardTester {
    static Card card1 = new Card("King", "Hearts", 13);
    static Card card2 = new Card("King", "Hearts", 13);
    static Card card3 = new Card("Queen", "Hearts", 12);

    public static void testCard(Card card){
        System.out.println(card.getRank());
        System.out.println(card.getSuit());
        System.out.println(card.getPointValue());
        System.out.println(card.matches(card2));
        System.out.println(card.toString());
    }

    public static void main(String[] args) {
        testCard(card1);
        testCard(card2);
        testCard(card3);
    }
}

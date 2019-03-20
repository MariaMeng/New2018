package ObjectOriented.Card;

/**
 * Created by apple on 10/25/18.
 */
public class Card {
    public enum Suit {Club , Space , Heart, Diamonds}
    private int card;
    private Suit suit;
    public Card(int r, Suit s) {
        card = r;
        suit = s;
    }

}

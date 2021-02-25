import java.util.ArrayList;

//カードの山札クラス
public class TrumpDeck {

    private ArrayList<Card> deck;

    TrumpDeck() {
        //山札作成
        this.deck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            this.deck.add(new Card("S", i));
            this.deck.add(new Card("H", i));
            this.deck.add(new Card("K", i));
            this.deck.add(new Card("D", i));
        }
        this.deck.add(new Card("Joker", 0));
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }
}
import java.util.ArrayList;

//�J�[�h�̎R�D�N���X
public class TrumpDeck {

    private ArrayList<Card> deck;

    TrumpDeck() {
        //�R�D�쐬
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
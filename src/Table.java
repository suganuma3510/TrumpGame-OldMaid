
import java.util.ArrayList;

//捨て札や上がったプレイヤーを管理するテーブルクラス
public class Table {

    //捨て札
    private ArrayList<Card> discards = new ArrayList<Card>();
    //上がったプレイヤー
    private ArrayList<Player> winPlayer = new ArrayList<Player>();

    public ArrayList<Card> getDiscards() {
        return this.discards;
    }

    public void setDiscards(Card discard) {
        this.discards.add(discard);
    }

    public ArrayList<Player> getWinPlayer() {
        return this.winPlayer;
    }

    public void setWinPlayer(Player winPlayer) {
        this.winPlayer.add(winPlayer);
    }
}

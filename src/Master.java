
import java.util.ArrayList;
import java.util.Collections;

//ゲームの進行をするマスタークラス
public class Master {

    private ArrayList<Player> player;
    private TrumpDeck trumpDeck;
    private Table field;

    public ArrayList<Player> getPlayer() {
        return this.player;
    }

    private void setPlayer(ArrayList<Player> player) {
        this.player = player;
    }

    public TrumpDeck getTrumpDeck() {
        return this.trumpDeck;
    }

    private void setTrumpDeck(TrumpDeck trumpDeck) {
        this.trumpDeck = trumpDeck;
    }

    public Table getField() {
        return this.field;
    }

    private void setField(Table field) {
        this.field = field;
    }

    //ゲームの準備をするメソッド
    public void prepareGame(ArrayList<Player> player, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setPlayer(player);
        setTrumpDeck(trumpDeck);
        handOutCards();
        for (Player p : player) {
            p.setField(field);
            //数字が同じ手札を捨てる
            p.discard();
            //プレイヤーの現在の手札を表示する
            p.showHand();
        }
    }

    //ババ抜きを始めるメソッド
    public void startGame() {
        System.out.println("【ババ抜きゲームを開始します】");
        //プレイヤーが１人になるまで繰り返す
        while (getPlayer().size() > 1) {
            drawHand();
        }
    }

    //手札を配るメソッド
    public void handOutCards() {
        System.out.println("【プレイヤーにカードを配ります】");
        //山札をシャッフルする
        Collections.shuffle(getTrumpDeck().getDeck());
        //山札がなくなるまで１枚ずつカードを配る
        while (getTrumpDeck().getDeck().isEmpty() == false) {
            for (int i = 0; i < getPlayer().size(); i++) {
                if (getTrumpDeck().getDeck().isEmpty()) {
                    break;
                }
                getPlayer().get(i).setHand(getTrumpDeck().getDeck().get(0));
                getTrumpDeck().getDeck().remove(0);
            }
        }
    }

    /*
    プレイヤーの手札を引き、同じ数字の手札を捨てるメソッドを呼び出し、
    手札がなくなったプレイヤーをチェックする
     */
    public void drawHand() {
        for (int i = 0; i < getPlayer().size(); i++) {
            System.out.println(getPlayer().get(i).getName() + "さんの番です");
            getPlayer().get(i).draw(getPlayer().get((i + 1) % getPlayer().size()));
            winPlayer();
        }
    }

    //上がったプレイヤーをチェックする
    public void winPlayer() {
        for (int i = 0; i < getPlayer().size(); i++) {
            if (getPlayer().get(i).getHand().isEmpty()) {
                System.out.println(getPlayer().get(i).getName() + "さんが上がりました！");
                getField().setWinPlayer(getPlayer().remove(i));
            }
        }
    }

    //ゲーム結果を表示する
    public void result() {
        System.out.println("【ゲーム終了】");
        System.out.println(getPlayer().get(0).getName() + "さんの負け");
    }
}

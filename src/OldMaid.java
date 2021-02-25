
import java.util.ArrayList;

public class OldMaid {

    public static void main(String[] args) {

        try {
            //プレイヤーの生成
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("村田"));
            player.add(new Player("山田"));
            //進行役の生成
            Master master = new Master();
            //山札の生成
            TrumpDeck trumpDeck = new TrumpDeck();
            //場の生成
            Table field = new Table();
            //進行役に場、プレイヤー、山札を渡しゲームの準備をする
            master.prepareGame(player, trumpDeck, field);
            //ゲームの開始
            master.startGame();
            //ゲーム結果
            master.result();
        } catch (Exception e) {
            //例外処理
            System.out.println("エラーが発生しました。");
            e.printStackTrace();
        }
    }
}

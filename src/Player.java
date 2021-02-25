
import java.util.ArrayList;
import java.util.Scanner;

//ババ抜きをするプレイヤークラス
public class Player {

    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private Table field;

    Player(String name) {
        if (name == null || name == "null") {
            throw new NullPointerException("名前がnullになっています。");
        }
        if (name.isEmpty()) {
            throw new RuntimeException("名前が空白になっています。");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("名前が長すぎます");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

    public Table getField() {
        return this.field;
    }

    public void setField(Table field) {
        this.field = field;
    }

    /*
    手札を分けられた後、準備段階として
    数字が同じ手札を捨てる処理を行うメソッド
     */
    public void discard() {
        for (int i = 0; i < getHand().size() - 1; i++) {
            for (int j = 1 + i; j < getHand().size(); j++) {
                if (getHand().get(i).getNumber() == getHand().get(j).getNumber()) {
                    System.out.println(getName() + "：" + getHand().get(i) + "："
                            + getHand().get(j) + "を捨てた");
                    getField().setDiscards(hand.remove(i));
                    getField().setDiscards(hand.remove(j - 1));
                    j = i;
                }
            }
        }
    }

    //プレイヤーの現在の手札を表示するメソッド
    public void showHand() {
        System.out.println(getName() + "さんの現在の手札");
        for (Card c : hand) {
            System.out.print(c.toString() + " ");
        }
        System.out.println("");
    }

    //相手の手札を１枚引くメソッド
    public void draw(Player player) {
        int choiceNum = inputChoice(player);
        setHand(player.getHand().get(choiceNum));
        System.out.print(getName() + "：");
        System.out.println(player.getName() + "さんから" + player.getHand().get(choiceNum) + "を引いた！");
        player.getHand().remove(choiceNum);
        //引いたカードと同じ数字があるかチェック
        discardCheck();
        //残りの手札を表示
        if (getHand().isEmpty() == false) {
            showHand();
        }
    }

    //相手から引いたカードと同じ数字の手札を探して捨てる
    public void discardCheck() {
        for (int i = 0; i < getHand().size() - 1; i++) {
            if (getHand().get(getHand().size() - 1).getNumber() == getHand().get(i).getNumber()) {
                System.out.print(getName() + "：");
                System.out.println(getHand().get(i) + "：" + getHand().get(getHand().size() - 1) + "を捨てた");
                //捨てると同時にテーブルへ捨て札を渡す
                getField().setDiscards(getHand().remove(i));
                getField().setDiscards(getHand().remove(getHand().size() - 1));
            }
        }
    }

    //相手から引くカードを標準入力で受け付けるメソッド
    public int inputChoice(Player player) throws UnsupportedSannerException {
        if (player.getHand().size() != 1) {
            System.out.println("相手の手札は" + player.getHand().size() + "枚あります。");
            System.out.println("何番目のカードを引きますか？");
            for (int i = 1; i <= player.getHand().size(); i++) {
                System.out.print("【" + i + "】 ");
            }
            System.out.println("");
            Scanner scanner = new Scanner(System.in);
            //入力される値をチェック
            while (true) {
                if (scanner.hasNextInt()) {
                    int choiceNum = scanner.nextInt();
                    if (choiceNum > player.getHand().size() || choiceNum < 1) {
                        //指定外の数字が入力された場合の例外処理
                        System.out.println("指定された数字を入力してください。");
                    } else {
                        return choiceNum - 1;
                    }
                } else {
                    //文字が入力された場合の例外処理
                    System.out.println("文字が入力されています。指定された数字で入力してください。");
                    scanner.next();
                }
            }
        }
        return 0;
    }
}

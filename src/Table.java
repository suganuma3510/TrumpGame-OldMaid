
import java.util.ArrayList;

//�̂ĎD��オ�����v���C���[���Ǘ�����e�[�u���N���X
public class Table {

    //�̂ĎD
    private ArrayList<Card> discards = new ArrayList<Card>();
    //�オ�����v���C���[
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


import java.util.ArrayList;

public class OldMaid {

    public static void main(String[] args) {

        try {
            //�v���C���[�̐���
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("���c"));
            player.add(new Player("�R�c"));
            //�i�s���̐���
            Master master = new Master();
            //�R�D�̐���
            TrumpDeck trumpDeck = new TrumpDeck();
            //��̐���
            Table field = new Table();
            //�i�s���ɏ�A�v���C���[�A�R�D��n���Q�[���̏���������
            master.prepareGame(player, trumpDeck, field);
            //�Q�[���̊J�n
            master.startGame();
            //�Q�[������
            master.result();
        } catch (Exception e) {
            //��O����
            System.out.println("�G���[���������܂����B");
            e.printStackTrace();
        }
    }
}

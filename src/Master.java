
import java.util.ArrayList;
import java.util.Collections;

//�Q�[���̐i�s������}�X�^�[�N���X
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

    //�Q�[���̏��������郁�\�b�h
    public void prepareGame(ArrayList<Player> player, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setPlayer(player);
        setTrumpDeck(trumpDeck);
        handOutCards();
        for (Player p : player) {
            p.setField(field);
            //������������D���̂Ă�
            p.discard();
            //�v���C���[�̌��݂̎�D��\������
            p.showHand();
        }
    }

    //�o�o�������n�߂郁�\�b�h
    public void startGame() {
        System.out.println("�y�o�o�����Q�[�����J�n���܂��z");
        //�v���C���[���P�l�ɂȂ�܂ŌJ��Ԃ�
        while (getPlayer().size() > 1) {
            drawHand();
        }
    }

    //��D��z�郁�\�b�h
    public void handOutCards() {
        System.out.println("�y�v���C���[�ɃJ�[�h��z��܂��z");
        //�R�D���V���b�t������
        Collections.shuffle(getTrumpDeck().getDeck());
        //�R�D���Ȃ��Ȃ�܂łP�����J�[�h��z��
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
    �v���C���[�̎�D�������A���������̎�D���̂Ă郁�\�b�h���Ăяo���A
    ��D���Ȃ��Ȃ����v���C���[���`�F�b�N����
     */
    public void drawHand() {
        for (int i = 0; i < getPlayer().size(); i++) {
            System.out.println(getPlayer().get(i).getName() + "����̔Ԃł�");
            getPlayer().get(i).draw(getPlayer().get((i + 1) % getPlayer().size()));
            winPlayer();
        }
    }

    //�オ�����v���C���[���`�F�b�N����
    public void winPlayer() {
        for (int i = 0; i < getPlayer().size(); i++) {
            if (getPlayer().get(i).getHand().isEmpty()) {
                System.out.println(getPlayer().get(i).getName() + "���񂪏オ��܂����I");
                getField().setWinPlayer(getPlayer().remove(i));
            }
        }
    }

    //�Q�[�����ʂ�\������
    public void result() {
        System.out.println("�y�Q�[���I���z");
        System.out.println(getPlayer().get(0).getName() + "����̕���");
    }
}

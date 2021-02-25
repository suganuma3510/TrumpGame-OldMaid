
import java.util.ArrayList;
import java.util.Scanner;

//�o�o����������v���C���[�N���X
public class Player {

    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private Table field;

    Player(String name) {
        if (name == null || name == "null") {
            throw new NullPointerException("���O��null�ɂȂ��Ă��܂��B");
        }
        if (name.isEmpty()) {
            throw new RuntimeException("���O���󔒂ɂȂ��Ă��܂��B");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("���O���������܂�");
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
    ��D�𕪂���ꂽ��A�����i�K�Ƃ���
    ������������D���̂Ă鏈�����s�����\�b�h
     */
    public void discard() {
        for (int i = 0; i < getHand().size() - 1; i++) {
            for (int j = 1 + i; j < getHand().size(); j++) {
                if (getHand().get(i).getNumber() == getHand().get(j).getNumber()) {
                    System.out.println(getName() + "�F" + getHand().get(i) + "�F"
                            + getHand().get(j) + "���̂Ă�");
                    getField().setDiscards(hand.remove(i));
                    getField().setDiscards(hand.remove(j - 1));
                    j = i;
                }
            }
        }
    }

    //�v���C���[�̌��݂̎�D��\�����郁�\�b�h
    public void showHand() {
        System.out.println(getName() + "����̌��݂̎�D");
        for (Card c : hand) {
            System.out.print(c.toString() + " ");
        }
        System.out.println("");
    }

    //����̎�D���P���������\�b�h
    public void draw(Player player) {
        int choiceNum = inputChoice(player);
        setHand(player.getHand().get(choiceNum));
        System.out.print(getName() + "�F");
        System.out.println(player.getName() + "���񂩂�" + player.getHand().get(choiceNum) + "���������I");
        player.getHand().remove(choiceNum);
        //�������J�[�h�Ɠ������������邩�`�F�b�N
        discardCheck();
        //�c��̎�D��\��
        if (getHand().isEmpty() == false) {
            showHand();
        }
    }

    //���肩��������J�[�h�Ɠ��������̎�D��T���Ď̂Ă�
    public void discardCheck() {
        for (int i = 0; i < getHand().size() - 1; i++) {
            if (getHand().get(getHand().size() - 1).getNumber() == getHand().get(i).getNumber()) {
                System.out.print(getName() + "�F");
                System.out.println(getHand().get(i) + "�F" + getHand().get(getHand().size() - 1) + "���̂Ă�");
                //�̂Ă�Ɠ����Ƀe�[�u���֎̂ĎD��n��
                getField().setDiscards(getHand().remove(i));
                getField().setDiscards(getHand().remove(getHand().size() - 1));
            }
        }
    }

    //���肩������J�[�h��W�����͂Ŏ󂯕t���郁�\�b�h
    public int inputChoice(Player player) throws UnsupportedSannerException {
        if (player.getHand().size() != 1) {
            System.out.println("����̎�D��" + player.getHand().size() + "������܂��B");
            System.out.println("���Ԗڂ̃J�[�h�������܂����H");
            for (int i = 1; i <= player.getHand().size(); i++) {
                System.out.print("�y" + i + "�z ");
            }
            System.out.println("");
            Scanner scanner = new Scanner(System.in);
            //���͂����l���`�F�b�N
            while (true) {
                if (scanner.hasNextInt()) {
                    int choiceNum = scanner.nextInt();
                    if (choiceNum > player.getHand().size() || choiceNum < 1) {
                        //�w��O�̐��������͂��ꂽ�ꍇ�̗�O����
                        System.out.println("�w�肳�ꂽ��������͂��Ă��������B");
                    } else {
                        return choiceNum - 1;
                    }
                } else {
                    //���������͂��ꂽ�ꍇ�̗�O����
                    System.out.println("���������͂���Ă��܂��B�w�肳�ꂽ�����œ��͂��Ă��������B");
                    scanner.next();
                }
            }
        }
        return 0;
    }
}

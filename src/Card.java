//�P���̃J�[�h�N���X
public class Card {

    private String mark;
    private int number;

    Card(String mark, int number) {
        setMark(mark);
        setNumber(number);
    }

    public String getMark() {
        return this.mark;
    }

    private void setMark(String mark) {
        this.mark = mark;
    }

    public int getNumber() {
        return this.number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    //�J�[�h�̖��O�𕶎���ŕԂ�
    @Override
    public String toString() {
        switch (getNumber()) {
            case 0:
                //�W���[�J�[
                return getMark();
            case 1:
                return getMark() + "A";
            case 11:
                return getMark() + "J";
            case 12:
                return getMark() + "Q";
            case 13:
                return getMark() + "K";
            default:
                return getMark() + getNumber();
        }
    }
}
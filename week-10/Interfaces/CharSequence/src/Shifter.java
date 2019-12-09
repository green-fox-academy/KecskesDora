public class Shifter implements CharSequence{

    private String text;
    private int shiftValue;

    public Shifter(String text, int shiftValue) {
        this.text = text;
        this.shiftValue = shiftValue;
    }

    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public char charAt(int index) {
        return this.text.charAt(index + 2);
    }

    @Override
    public CharSequence subSequence(int startChar, int endChar) {
        return this.text.substring(startChar + 2, endChar + 2);
    }
}

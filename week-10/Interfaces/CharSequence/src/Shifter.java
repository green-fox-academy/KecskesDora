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
        if (index < -2 || index > this.text.length() - 3) {
            throw new IndexOutOfBoundsException();
        }
        return this.text.charAt(index + 2);
    }

    @Override
    public CharSequence subSequence(int startChar, int endChar) {
        if (startChar < -2 || endChar < -2 || startChar > endChar || endChar > this.text.length() - 3) {
            throw new IndexOutOfBoundsException();
        }
        return this.text.substring(startChar + 2, endChar + 2);
    }
}

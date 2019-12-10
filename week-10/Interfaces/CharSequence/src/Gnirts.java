public class Gnirts implements CharSequence{
    private String text;

    public Gnirts(String name) {
        this.text = name;
    }

    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index > this.text.length() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return this.text.charAt(this.text.length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int startChar, int endChar) {
        if (startChar < 0 || endChar < 0 || endChar > this.text.length() || startChar > endChar) {
            throw new IndexOutOfBoundsException();
        }
        String reversedSequence = "";
        for (int i = endChar; i >= startChar; i--) {
            reversedSequence += this.text.charAt(i);
        }
        return reversedSequence;
    }
}

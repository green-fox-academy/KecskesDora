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
        return this.text.charAt(this.text.length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int startChar, int endChar) {
        String reversedSequence = "";

        for (int i = endChar; i >= startChar; i--) {
            reversedSequence += this.text.charAt(i);
        }
        return reversedSequence;
    }
}

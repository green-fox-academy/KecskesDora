public class TakesLonger {
    public static void main(String... args){
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

        int indexOfyou = quote.indexOf("you");
        String quote1 = quote.substring(0, indexOfyou);
        String quote2 = quote.substring(indexOfyou - 1, quote.length());
        quote = quote1 + "always takes longer than" + quote2;

        System.out.println(quote);
    }
}
// When saving this quote a disk error has occured. Please fix it.
// Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
// Using pieces of the quote variable (instead of just redefining the string)
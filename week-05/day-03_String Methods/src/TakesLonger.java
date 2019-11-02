public class TakesLonger {
    public static void main(String... args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

        String quote1 = quote.substring(0, quote.indexOf("It") + 3);
        String quote2 = quote.substring(quote.indexOf("It") + 2, quote.length());
        quote = quote1.concat("always takes longer than").concat(quote2);
        System.out.println(quote);
     }
}
// When saving this quote a disk error has occured. Please fix it.
// Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
// Using pieces of the quote variable (instead of just redefining the string)
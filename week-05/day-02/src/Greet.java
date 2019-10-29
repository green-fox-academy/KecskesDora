public class Greet {
    public static void main(String[] args) {
        String al = "Green Fox";
        System.out.println(greetFunction(al));
    }
    public static String greetFunction(String al) {
        String greeting = "Greetings dear, " + al;
        return greeting;
    }
}
// - Create a string variable named `al` and assign the value `Green Fox` to it
// - Create a function called `greet` that greets it's input parameter
//     - Greeting is printing e.g. `Greetings dear, Green Fox`
// - Greet `al`
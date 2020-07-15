public class RepeatedString {

  public static void main(String[] args) {

    System.out.println(repeatedString("abcac", 10));

  }

  static long repeatedString(String s, long n) {
    long length = s.length();
    long repeat = n / length;
    long remainder = n % length;
    long allAChars = 0;
    long restAChars = 0;
    for (int i = 0; i < length; i++) {
      if (String.valueOf(s.charAt(i)).equals("a")) {
        allAChars++;
        if (i < remainder) {
          restAChars++;
        }
      }
    }
    return repeat * allAChars + restAChars;
  }

}

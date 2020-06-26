import java.util.Hashtable;

public class RansomNote {

  public static void main(String[] args) {

    String[] magazine = {"two", "times", "three", "is", "not", "four"};
    String[] note = {"two", "times", "two", "is", "four"};
    checkMagazine(magazine, note);

  }

  static void checkMagazine(String[] magazine, String[] note) {
    Hashtable<String, Integer> tableMagazine = createTable(magazine);
    Hashtable<String, Integer> tableNote = createTable(note);

    boolean result;
    for (String word : tableNote.keySet()) {
      result = tableMagazine.containsKey(word) && tableMagazine.get(word) >= (tableNote.get(word));
      if (!result) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }

  public static Hashtable<String, Integer> createTable(String[] words) {
    Hashtable<String, Integer> table = new Hashtable<>();
    for (String word : words) {
      if (table.containsKey(word)) {
        table.put(word, table.get(word) + 1);
      } else {
        table.put(word, 1);
      }
    }
    return table;
  }

}

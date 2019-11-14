import java.util.*;

public class Matchmaking{
    public static void main(String... args){
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve","Ashley","Claire","Kat","Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe","Fred","Tom","Todd","Neef","Jeff", "Attila", "Zsombi"));

        // Write a method that joins the two lists by matching one girl with one boy into a new list
        // If someone has no pair, he/she should be the element of the list too
        // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

        System.out.println(makingMatches(girls, boys));
    }
    public static ArrayList<String> makingMatches(ArrayList<String> girls, ArrayList<String> boys) {
        ArrayList<String> girlsAndBoys = new ArrayList<String>(girls.size() + boys.size());
        int a = 0;
        for (int i = 0; i < girls.size(); i ++) {

        girlsAndBoys.add(i + a, girls.get(i));
        girlsAndBoys.add(i + 1 + a, boys.get(i));
            a++;
        }
            for (int j = 0; j < (boys.size() - girls.size()); j++) {
                girlsAndBoys.add((girlsAndBoys.size()), boys.get(j + girls.size()));
        }
        return girlsAndBoys;
    }
}

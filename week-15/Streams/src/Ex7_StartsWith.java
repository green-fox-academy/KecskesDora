import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex7_StartsWith {
    public static void main(String[] args) {
        //Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:
        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");

        System.out.println(startsWith(cities, "A"));

        }

        public static List<String> startsWith(List<String> cities, String letter) {

        List<String> citiesStartsWith = cities.stream()
                .filter(c -> c.startsWith(letter))
                .collect(Collectors.toList());

            return citiesStartsWith;
        }
    }


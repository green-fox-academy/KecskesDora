import java.util.HashMap;
import java.util.Map;

public class TelephoneBook {
    public static void main(String[] args) {
        HashMap<String, String> telBook = new HashMap<>();
        telBook.put("William A. Lathan", "405-709-1865");
        telBook.put("John K. Miller", "402-247-8568");
        telBook.put("Hortensia E. Foster", "606-481-6467");
        telBook.put("Amanda D. Newland", "319-243-5613");
        telBook.put("Brooke P. Askew", "307-687-2982");

        //What is John K. Miller's phone number?
        System.out.println(telBook.get("John K. Miller"));

        //Whose phone number is 307-687-2982?
        String phoneNumber = "307-687-2982";
        for (Map.Entry<String, String> book : telBook.entrySet()) {
            if (book.getValue() == phoneNumber) {
                System.out.println(book.getKey());
            }
        }

        //Do we know Chris E. Myers' phone number?
        String nameLookedFor = "Chris E. Myers";
        if (telBook.containsKey(nameLookedFor) == true) {
            System.out.println("Yes, his number is: " + telBook.get(nameLookedFor) + ".");
            } else {
            System.out.println("We don't know the phone number of " + nameLookedFor + ".");
        }
    }
}




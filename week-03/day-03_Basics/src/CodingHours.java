public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        //
        System.out.println("An attendee spend " + (6 * 5 * 17) + " hours with coding in a semester.");
        //
        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52
        //
        System.out.println("Percentage of the coding hours in the semester: " + (6 * 5 * 17)*100/(52*17) + " %");
        //System.out.println("Percentage of the coding hours in the semester: " + 52*100/(7*24) + " %");
    }
}
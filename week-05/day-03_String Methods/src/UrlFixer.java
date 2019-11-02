public class UrlFixer {
    public static void main(String... args){
        String url = "https//www.reddit.com/r/nevertellmethebots";

        url = url.replace("bot", "odd");
        url = url.replace("https", "https:");
        System.out.println(url);

        //OR
        url = "https//www.reddit.com/r/nevertellmethebots";

        String urlPart1 = url.substring(0, 5);
        String urlPart2 = url.substring(5, url.length());
        url = urlPart1 + ":" + urlPart2;
        urlPart1 = url.substring(0, url.length() - 4);
        url = urlPart1 + "odds";
        System.out.println(url);

    }
}
// Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
// Also, the URL is missing a crutial component, find out what it is and insert it too!
// Try to solve it more than once using different String functions!
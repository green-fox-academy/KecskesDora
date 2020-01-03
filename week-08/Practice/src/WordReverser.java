//Create a function that takes a sentence as an input, reverses the letters in every word
// (but not reverses the word order in the sentence), and returns the sentence with the reversed words.
// You shouldn't care about upper or lower case letters.
//
//Write at least 2 different unit test cases.


public class WordReverser {

    public String reverseWords(String sentence) throws SentenceIsMissingException{
        if (sentence == "" || sentence == null) {
            throw new SentenceIsMissingException();
        }

        String[] words = sentence.split(" ");
        String word = "";
        String newSentence = "";

        for (int indexOfWords = 0; indexOfWords < words.length; indexOfWords++) {
            for (int indexOfChar = words[indexOfWords].length() - 1; indexOfChar >= 0; indexOfChar--) {
                word += words[indexOfWords].charAt(indexOfChar);
            }
            newSentence += word + " ";
            word = "";
        }
        //cut space from last char
        newSentence = newSentence.substring(0, newSentence.length() - 1);
        return newSentence;
    }

    public String reverseWordsWithStringBuilder(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder word = new StringBuilder();
        StringBuilder newSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
           word = word.append(words[i]).reverse();
           if (i != words.length - 1) {
               newSentence.append(word + " ");
           } else {
               newSentence.append(word);
           }
           //empty StringBuilder:
           word.setLength(0);
        }
        return newSentence.toString();
    }
}

package algorithm.day19;

import org.junit.Test;

public class Part0151Test {

    @Test
    public void reverseWords() {
        Part0151 test = new Part0151();
        String s = "a good   example";
        String words = test.reverseWords(s);
        System.out.println(words);
    }
}
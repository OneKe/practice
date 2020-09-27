package algorithm.day37;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class Part0459 {
    public boolean repeatedSubstringPattern(String s) {
        //s = abcabcabcabc
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}

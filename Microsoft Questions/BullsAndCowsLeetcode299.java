package com.gyaneshwar.Leetcode;

import java.util.Arrays;

public class BullsAndCowsLeetcode299 {
    public static void main(String[] args) {
        System.out.println(getHint("00112233445566778899","16872590340158679432"));
    }
    static String getHint(String secret, String guess) {
        int m = secret.length();
        int a = countMatch(secret,guess, m);
        String secretA=sortString(secret);
        String guessA=sortString(guess);
        int b = count(secretA,guessA, m)-a;
        String s1 = Integer.toString(a), s2 = Integer.toString(b);
        String s = s1+"A"+s2+"B";
        return s;
    }

    static int count(String secretA, String guessA, int m) {
        int count = 0, k=0;
        for(int i=0; i<m; i++){
            for(int j=k; j<m; j++){
                if (secretA.charAt(i)==guessA.charAt(j)){
                    count++;
                    k=j+1;
                    break;
                }
            }
        }
        return count;
    }

    static int countMatch(String secret, String guess, int m){
        int count = 0;
        for(int i=0; i<m; i++){
            if(secret.charAt(i)==guess.charAt(i))
                count++;
        }
        return count;
    }
    static String sortString(String inputString)
    {
        char[] tempArray = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}

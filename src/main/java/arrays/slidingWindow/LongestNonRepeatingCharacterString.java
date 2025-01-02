package main.java.arrays.slidingWindow;

import java.util.*;

/*
Problem Statement: Given a String, find the length of longest substring without any repeating character.

Examples:

Example 1:

Input: s = ”abcabcbb”

Output: 3

Explanation: The answer is abc with length of 3.

Example 2:

Input: s = ”bbbbb”

Output: 1

Explanation: The answer is b with length of 1 units.
 */
public class LongestNonRepeatingCharacterString {

    /*
    Please refer findLongestNonRepeatingSubstringAlternateSolution before this ,
    you cannot come to this solution before that
    Also dry run using abcaabcdba to understand
    Time complexity : O(n),
    Space complexity: O(n)
    */
    public int findOptimisedLongestNonRepeatingSubstring(String inputString) {
        int r = 0, l = 0, maxlen = 0;
        Map<Character, Integer> characters = new HashMap<>();
        //map stores latest position of an alphabet at a given point via right pointer

        while (l <= r && r < inputString.length()) {
            if (characters.containsKey(inputString.charAt(r))) {
                l = Math.max(characters.get(inputString.charAt(r)) + 1, l);
                /*in case of abca , map will return max(0+1, 0) =1 , so l =1 i.e point to b
                incase of abcaa, map will return last stored position of a =3 max(3+1,1) =4 ,
                 so l =4, so now l will point to last a
                 */
            }
            characters.put(inputString.charAt(r), r);// maps stores latest position of an alphabet if it repeats
            maxlen = Math.max(maxlen, r - l + 1);
            r++;


        }
        return maxlen;
    }

    /*
    Time complexity : O(n^2)
    Space complexity: O(n)
     */
    public int findBruteForceLongestNonRepeatingSubstring(String inputString) {
        String outputString = new String();
        HashMap<Integer, List<Set<Character>>> subStrings = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < inputString.length(); i++) {
            Set<Character> characters = new HashSet<>();
            for (int j = i; j < inputString.length(); j++) {
                if (characters.contains(inputString.charAt(j))) {
//                   incase you need those substrings of max length this logic to be used
//                   if (subStrings.containsKey(characters.size())) {
//                        subStrings.get(characters.size()).add(characters);
//                    } else {
//                        subStrings.put(characters.size(), new ArrayList<>(Set.of(characters)));
//                    }
                    break;
                }
                characters.add(inputString.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);

            }
        }
        // return substring.get(maxlen);
        return maxLen;
    }

    /*
 Time complexity : O(n), o(n^2) in case of same alphabets on l and r
 Space complexity: O(n)
  */
    public int findLongestNonRepeatingSubstringAlternateSolution(String inputString) {
        int r = 0, l = 0, maxlen = 0;
        Set<Character> characters = new HashSet<>();

        while (l <= r && r < inputString.length()) {
            if (characters.contains(inputString.charAt(r))) {
                while (characters.contains(inputString.charAt(r))) {
                    // keeping an if condition instead of while fails if l and r point to same alphabets at different indexes,
                    // a in takeUForward , hence an extra while
                    //same chars will mostly be at edges , hence removing l
                    characters.remove(inputString.charAt(l));
                    l++;
                }

            }
            maxlen = Math.max(maxlen, r - l + 1);
            characters.add(inputString.charAt(r));
            r++;


        }
        return maxlen;
    }

    public static void main(String[] args) {
        LongestNonRepeatingCharacterString longestNonRepeatingCharacterString = new LongestNonRepeatingCharacterString();


        //Brute force approach
        String s = new String("abcabcbb");
        String s1 = new String("bbbbbbb");
        String s2 = "geeksforgeeks";
        String s3 = "takeUforward";
        String s4 = "abcaabcdba";
        System.out.println("Brute Force Longest substring with non repeating characters for " + s + " is : " + longestNonRepeatingCharacterString.findBruteForceLongestNonRepeatingSubstring(s));
        System.out.println("Brute force Longest substring with non repeating characters for " + s1 + " is : " + longestNonRepeatingCharacterString.findBruteForceLongestNonRepeatingSubstring(s1));


        System.out.println("Optimised Sol1 Longest substring with non repeating characters for " + s + " is : " + longestNonRepeatingCharacterString.findLongestNonRepeatingSubstringAlternateSolution(s));
        System.out.println("Optimised Sol1 Longest substring with non repeating characters for " + s1 + " is : " + longestNonRepeatingCharacterString.findLongestNonRepeatingSubstringAlternateSolution(s1));
        System.out.println("Optimised Sol1 Longest substring with non repeating characters for " + s2 + " is : " + longestNonRepeatingCharacterString.findLongestNonRepeatingSubstringAlternateSolution(s2));
        System.out.println("Optimised Sol1 Longest substring with non repeating characters for " + s3 + " is : " + longestNonRepeatingCharacterString.findLongestNonRepeatingSubstringAlternateSolution(s3));
        System.out.println("Optimised Sol1 Longest substring with non repeating characters for " + s4 + " is : " + longestNonRepeatingCharacterString.findLongestNonRepeatingSubstringAlternateSolution(s4));


        System.out.println("Most Optimised solution Longest substring with non repeating characters for " + s + " is : " + longestNonRepeatingCharacterString.findOptimisedLongestNonRepeatingSubstring(s));
        System.out.println("Most Optimised solution Longest substring with non repeating characters for " + s1 + " is : " + longestNonRepeatingCharacterString.findOptimisedLongestNonRepeatingSubstring(s1));
        System.out.println("Most Optimised solution Longest substring with non repeating characters for " + s2 + " is : " + longestNonRepeatingCharacterString.findOptimisedLongestNonRepeatingSubstring(s2));
        System.out.println("Most Optimised solution Longest substring with non repeating characters for " + s3 + " is : " + longestNonRepeatingCharacterString.findOptimisedLongestNonRepeatingSubstring(s3));
        System.out.println("Most Optimised solution Longest substring with non repeating characters for " + s4 + " is : " + longestNonRepeatingCharacterString.findOptimisedLongestNonRepeatingSubstring(s4));


    }
}

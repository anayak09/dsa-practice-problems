package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountOccurencesOfAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = findAnagrams(s,p);
    }

    // Return the start indices of the occurences (p's anagrams in "s" string)
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int countChar = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();

        int lenP = p.length();

        for(int x=0; x<lenP; x++) {
            countMap.put(p.charAt(x), countMap.getOrDefault(p.charAt(x), 0) + 1);
        }

        countChar = countMap.size();
        int lenS = s.length();
        int j=0, i=0;

        while (j < lenS) {
            if(countMap.containsKey(s.charAt(j))) {
                int value = countMap.get(s.charAt(j));
                countMap.put(s.charAt(j), value-1);

                if(value-1 == 0) {
                    countChar--;
                }
            }

            if(j - i + 1 < lenP) {
                j++;
            }
            else {
                if(countChar == 0) {
                    result.add(i);
                }

                // Since we only need those elements in map which are there in String "p"
                if(countMap.get(s.charAt(i)) != null) {
                    int value = countMap.get(s.charAt(i));
                    if(value == 0) {
                        countChar++;
                    }
                    countMap.put(s.charAt(i), value + 1);
                }

                i++;
                j++;
            }
        }

        return result;
    }
}

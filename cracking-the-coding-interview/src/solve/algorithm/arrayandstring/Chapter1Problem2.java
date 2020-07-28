package solve.algorithm.arrayandstring;

import solve.algorithm.utils.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

순열확인: 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드를 작성하라.

 */
public class Chapter1Problem2 {
    public static boolean checkPermutation1(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }

        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();
        Arrays.sort(sourceArray);
        Arrays.sort(targetArray);

        for (int i = 0;i < sourceArray.length;i++) {
            if (sourceArray[i] != targetArray[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkPermutation2(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i < source.length();i++) {
            Character character = source.charAt(i);
            if (!map.containsKey(character)) {
                map.put(character, 0);
            }
            map.put(character, map.get(character) + 1);
        }

        for (int i = 0;i < target.length();i++) {
            Character character = target.charAt(i);
            if (!map.containsKey(character)) {
                return false;
            }
            map.put(character, map.get(character) - 1);
            if (map.get(character) < 0) {
                return false;
            }
        }

        return true;
    }

    public static void test() {
        String[] testCases1 = { "abaab", "qwerty", "cccccc", "apple", "aef", "lele" };
        String[] testCases2 = { "bbaaa", "ywertq", "cccccca", "apple", "fee", "eiei" };
        boolean[] answers = { true, true, false, true, false, false };

        int n = testCases1.length;

        Util.printTestTitle("Chapter1Problem2");
        Util.printTestSubTitle("Solution1");
        for (int i = 0;i < n;i++) {
            Util.printTestResult(i, n, answers[i] == checkPermutation1(testCases1[i], testCases2[i]));
        }
        Util.printTestSubTitle("Solution2");
        for (int i = 0;i < n;i++) {
            Util.printTestResult(i, n, answers[i] == checkPermutation2(testCases1[i], testCases2[i]));
        }
    }
}

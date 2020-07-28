package solve.algorithm.arrayandstring;

import java.util.HashSet;
import java.util.Set;

/*

중복이 없는가: 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어
등장하는지 확인하는 알고리즘을 작성하라. 자료구조를 추가로 사용하지 않고
풀 수 있는 알고리즘을 또한 고민하라.

 */
public class Problem1 {
    public static boolean solution1(String sentence) {
        Set<Character> characters = new HashSet<>();

        for (int i = 0;i < sentence.length();i++) {
            Character character = sentence.charAt(i);
            if (characters.contains(character)) {
                return false;
            }
            characters.add(character);
        }

        return true;
    }

    public static void test() {
        String[] testCases = { "orange", "aabcd", "abcdd", "apple", "salt" };
        boolean[] answers = { true, false, false, false, true };

        int n = testCases.length;

        System.out.println("===== Solution1 =====");
        for (int i = 0;i < n;i++) {
            String result = answers[i] == solution1(testCases[i]) ? "Success" : "Fail";
            System.out.println((i+1) + " / " + n + ": " + result);
        }

        System.out.println("===== Solution2 =====");
        for (int i = 0;i < n;i++) {
            String result = answers[i] == solution1(testCases[i]) ? "Success" : "Fail";
            System.out.println((i+1) + " / " + n + ": " + result);
        }
    }
}

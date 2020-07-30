package solve.algorithm.arrayandstring;

import solve.algorithm.utils.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

URL화: 문자열에 들어 있는 모든 공백을 '%20'으로 바꿔주는 메서드를 작성하라. 최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이 이미
확보되어 있으며 문자열의 최종 길이가 함꼐 주어진다고 가정해도 된다(자바로 구현한다면 배열 안에서 작업할 수 있도록 문자 배열을 이용하길 바란다.)

 */
public class Chapter1Problem3 {
    public static String escapeSpace(String sentence) {
        char[] chars = sentence.toCharArray();

        int trueLength = 0;
        for (int i = chars.length - 1;i >= 0;i--) {
            if (chars[i] != ' ') {
                trueLength = i + 1;
                break;
            }
        }

        int spaceCount = 0;
        for (int i = 0;i < trueLength;i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2 - 1;
        for (int i = trueLength - 1;i >= 0;i--) {
            if (chars[i] == ' ') {
                chars[index - 2] = '%';
                chars[index - 1] = '2';
                chars[index] = '0';
                index -= 3;
            } else {
                chars[index] = chars[i];
                index -= 1;
            }
        }

        return String.copyValueOf(chars);
    }

    public static void test() {
        String[] testCases = { "this is test    ", "very good test    ", "hahaha" };
        String[] answers = { "this%20is%20test", "very%20good%20test", "hahaha" };

        int n = testCases.length;

        Util.printTestTitle("Chapter1Problem2");
        Util.printTestSubTitle("Solution1");
        for (int i = 0;i < n;i++) {
            Util.printTestResult(i, n, answers[i].equals(escapeSpace(testCases[i])));
        }
    }
}

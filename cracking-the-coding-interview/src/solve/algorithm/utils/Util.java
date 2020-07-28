package solve.algorithm.utils;

public class Util {
    public static void printTestTitle(String title) {
        System.out.print(ConsoleColors.BLUE);
        System.out.println("==========" + title + "=========");
        System.out.print(ConsoleColors.RESET);
    }

    public static void printTestSubTitle(String subTitle) {
        System.out.print(ConsoleColors.BLUE);
        System.out.println("[" + subTitle + "]");
        System.out.print(ConsoleColors.RESET);
    }

    public static void printTestResult(int count, int total, boolean isSuccess) {
        System.out.print(isSuccess ? ConsoleColors.CYAN_BOLD_BRIGHT : ConsoleColors.RED_BOLD_BRIGHT);
        System.out.println("(" + (count+1) + "/" + total + "): " + (isSuccess ? "Success" : "Fail"));
        System.out.print(ConsoleColors.RESET);
    }
}

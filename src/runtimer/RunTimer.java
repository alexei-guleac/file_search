package runtimer;

public class RunTimer {

    static long timeStart, timeEnd;

    public static void initTimeStart() {
        timeStart = System.currentTimeMillis();
    }

    public static void initTimeEnd() {
        timeEnd = System.currentTimeMillis();
    }

    //Показать время выполнения команд
    public static void showRunTime() {
        long execTime = timeEnd - timeStart;
        System.out.println("Время выполнения: " + (execTime * 0.001) + " с");
    }
}

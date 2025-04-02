package Utility;

public class MyFunc {
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void CloseFaultyWindows() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {
        }
    }
}

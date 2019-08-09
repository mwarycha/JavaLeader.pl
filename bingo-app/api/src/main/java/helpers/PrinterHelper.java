package helpers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PrinterHelper {

    public static void printLog(String msgLog) {
        System.out.println("[LOG " + getWarsawTime()  + "] " + msgLog);
    }

    private static String getWarsawTime() {
        LocalDateTime warsawTime = LocalDateTime.now(ZoneId.of("Europe/Warsaw"));
        return warsawTime.format(DateTimeFormatter.ofPattern("HH::mm::ss"));
    }
}

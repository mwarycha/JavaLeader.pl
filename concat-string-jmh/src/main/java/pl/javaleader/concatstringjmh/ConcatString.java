package pl.javaleader.concatstringjmh;

public class ConcatString {

    public static String concatByStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        return stringBuilder.toString();
    }

    public static String concatByStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            stringBuffer.append(String.valueOf(i));
        }
        return stringBuffer.toString();
    }

    public static String concatByPlusOperator() {
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result +=  String.valueOf(i);
        }
        return result;
    }
}

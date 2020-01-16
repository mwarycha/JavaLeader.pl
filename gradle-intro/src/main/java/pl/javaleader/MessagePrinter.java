package pl.javaleader;

public class MessagePrinter {

    public static void main(String[] args) {

        MsgService msgService = new MsgServiceImpl();
        msgService.showMsg();

        System.out.println();

    }

}

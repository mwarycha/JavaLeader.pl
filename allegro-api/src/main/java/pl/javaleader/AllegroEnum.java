package pl.javaleader;

public enum AllegroEnum {
    ACCEPT ("application/vnd.allegro.public.v1+json");
    public String acceptHeader;
    AllegroEnum(String ACCEPT) {
        acceptHeader = ACCEPT;
    }
}
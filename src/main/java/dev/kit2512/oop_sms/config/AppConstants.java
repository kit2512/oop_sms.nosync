package dev.kit2512.oop_sms.config;

public class AppConstants {

    public static class StringPattern {

        public static final String namePattern = "^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$";
        public static final String phoneNumberPattern = "^(\\+?[01])?[-.\\s]?\\(?[1-9]\\d{2}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}";
        public static final String emailPattern = """
                                                   ^((?>[a-zA-Z\\d!#$%&'*+\\-/=?^_`{|}~]+\\x20*|"((?=[\\x01-\\x7f])[^"\\\\]|\\\\[\\x01-\\x7f])*
                                                   "\\x20*)*(?<angle><))?((?!\\.)(?>\\.?[a-zA-Z\\d!#$%&'*+\\-/=?^_`{|}~]+)+|"((?=[\\x01-\\x
                                                   7f])[^"\\\\]|\\\\[\\x01-\\x7f])*")@(((?!-)[a-zA-Z\\d\\-]+(?<!-)\\.)+[a-zA-Z]{2,}|\\[(((?(?<
                                                   !\\[)\\.)(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)){4}|[a-zA-Z\\d\\-]*[a-zA-Z\\d]:((?=[\\x01-\\x7f])
                                                   [^\\\\\\[\\]]|\\\\[\\x01-\\x7f])+)\\])(?(angle)>)$""";
    }
    
    public static class DatabasePath {
        public static final String usersDatabase = "jdbc:sqlite:oop_sms.sqlite";
    }
}

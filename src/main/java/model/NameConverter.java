package model;

public class NameConverter {
    private String nameForCheck;
    public final static String NOT_VALID_NAME = "not_valid_user_name";
    private static String russianChars = "абвгдеёжзиклмнопрстуфхчшщьыъэюя";

    private static String[] charsToExchange = {"a","b","v","g","d","e","yo","zh","z",
    "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "ph", "h", "ch", "sh", "sh'", "'", "y", "", "a", "u", "ya"};

    public String doCheck(String nameForCheck) {
        this.nameForCheck = nameForCheck;

        if (nameForCheck == null || nameForCheck.trim().equals("")) {
            return NOT_VALID_NAME;
        }

        if (nameForCheck.trim().toLowerCase().matches("[a-z1-9а-я]+")) {
            return doTranslate();
        }

        return NOT_VALID_NAME;
    }

    private String doTranslate() {
        StringBuilder translatedName = new StringBuilder();

        for (char c : nameForCheck.trim().toLowerCase().toCharArray()) {
            if (russianChars.indexOf(c) != -1) {
                int indexOfExchangeable = russianChars.indexOf(c);
                translatedName.append(charsToExchange[indexOfExchangeable]);

            } else {
                translatedName.append(c);
            }
        }

        translatedName.replace(0,1,String.valueOf(translatedName.charAt(0)).toUpperCase());
        return translatedName.toString();
    }
}

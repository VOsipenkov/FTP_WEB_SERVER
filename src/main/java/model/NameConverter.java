package model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameConverter {
    private String nameForCheck;
    public final static String NOT_VALID_NAME = "not_valid_user_name";
    private static String russianChars = "абвгдеёжзиклмнопрстуфхчшщьыъэюя";

    private static String[] charsToExchange = {"a","b","v","g","d","e","yo","zh","z",
    "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "ph", "h", "ch", "sh", "sh'", "'", "y", "", "a", "u", "ya"};

    public String doCheck(String nameForCheck) {
        this.nameForCheck = nameForCheck;

        if (nameForCheck != null && !Objects.equals(nameForCheck, "")
                && nameForCheck.trim().toLowerCase().matches("[a-z1-9а-яА-Я]+[a-z1-9а-яА-Я\\s]*")) {

            return doTranslate();
        }

        return null;
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

        int spaceIndex = -1;
        Matcher matcher = Pattern.compile(".*[\\s]+").matcher(translatedName);
        if (matcher.find()){
            spaceIndex = matcher.end();
        }

        if (spaceIndex != -1) {
            translatedName.replace(spaceIndex, spaceIndex + 1, String.valueOf(translatedName.charAt(spaceIndex)).toUpperCase());
        }

        return translatedName.toString();
    }
}

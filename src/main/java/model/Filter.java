package model;

public class Filter {
    private boolean containsNumber = false;
    private boolean containsChar = false;
    private String containsWord = null;

    public Filter(){}

    public Filter(boolean containsNumber, boolean containsChar, String containsWord) {
        this.containsNumber = containsNumber;
        this.containsChar = containsChar;
        this.containsWord = containsWord;
    }

    public boolean isContainsNumber() {
        return containsNumber;
    }

    public void setContainsNumber(boolean containsNumber) {
        this.containsNumber = containsNumber;
    }

    public boolean isContainsChar() {
        return containsChar;
    }

    public void setContainsChar(boolean containsChar) {
        this.containsChar = containsChar;
    }

    public String getContainsWord() {
        return containsWord;
    }

    public void setContainsWord(String containsWord) {
        this.containsWord = containsWord;
    }
}

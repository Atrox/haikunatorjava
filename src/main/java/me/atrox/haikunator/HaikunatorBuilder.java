package me.atrox.haikunator;

public class HaikunatorBuilder {
    private String delimiter = "-";
    private String tokenChars = "0123456789";
    private int tokenLength = 4;
    private boolean tokenHex = false;

    public Haikunator build() {
        return new Haikunator(this);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public HaikunatorBuilder setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    public String getTokenChars() {
        return tokenChars;
    }

    public HaikunatorBuilder setTokenChars(String tokenChars) {
        this.tokenChars = tokenChars;
        return this;
    }

    public int getTokenLength() {
        return tokenLength;
    }

    public HaikunatorBuilder setTokenLength(int tokenLength) {
        this.tokenLength = tokenLength;
        return this;
    }

    public boolean isTokenHex() {
        return tokenHex;
    }

    public HaikunatorBuilder setTokenHex(boolean tokenHex) {
        this.tokenHex = tokenHex;
        return this;
    }
}

package me.atrox.haikunator;

public class HaikunatorBuilder {
    private String delimiter = "-", tokenChars = "0123456789";
    private int tokenLength = 4;
    private boolean tokenHex = false;

    public HaikunatorBuilder setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    public HaikunatorBuilder setTokenChars(String tokenChars) {
        this.tokenChars = tokenChars;
        return this;
    }

    public HaikunatorBuilder setTokenLength(int tokenLength) {
        this.tokenLength = tokenLength;
        return this;
    }

    public HaikunatorBuilder setTokenHex(boolean tokenHex) {
        this.tokenHex = tokenHex;
        return this;
    }

    public Haikunator build() {
        return new Haikunator(delimiter, tokenChars, tokenLength, tokenHex);
    }
}
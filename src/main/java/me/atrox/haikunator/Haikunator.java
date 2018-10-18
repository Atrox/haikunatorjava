package me.atrox.haikunator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Haikunator {
    private String[] adjectives = {
            "aged", "ancient", "autumn", "billowing", "bitter", "black", "blue", "bold",
            "broad", "broken", "calm", "cold", "cool", "crimson", "curly", "damp",
            "dark", "dawn", "delicate", "divine", "dry", "empty", "falling", "fancy",
            "flat", "floral", "fragrant", "frosty", "gentle", "green", "hidden", "holy",
            "icy", "jolly", "late", "lingering", "little", "lively", "long", "lucky",
            "misty", "morning", "muddy", "mute", "nameless", "noisy", "odd", "old",
            "orange", "patient", "plain", "polished", "proud", "purple", "quiet", "rapid",
            "raspy", "red", "restless", "rough", "round", "royal", "shiny", "shrill",
            "shy", "silent", "small", "snowy", "soft", "solitary", "sparkling", "spring",
            "square", "steep", "still", "summer", "super", "sweet", "throbbing", "tight",
            "tiny", "twilight", "wandering", "weathered", "white", "wild", "winter", "wispy",
            "withered", "yellow", "young"
    };
    private String[] nouns = {
            "art", "band", "bar", "base", "bird", "block", "boat", "bonus",
            "bread", "breeze", "brook", "bush", "butterfly", "cake", "cell", "cherry",
            "cloud", "credit", "darkness", "dawn", "dew", "disk", "dream", "dust",
            "feather", "field", "fire", "firefly", "flower", "fog", "forest", "frog",
            "frost", "glade", "glitter", "grass", "hall", "hat", "haze", "heart",
            "hill", "king", "lab", "lake", "leaf", "limit", "math", "meadow",
            "mode", "moon", "morning", "mountain", "mouse", "mud", "night", "paper",
            "pine", "poetry", "pond", "queen", "rain", "recipe", "resonance", "rice",
            "river", "salad", "scene", "sea", "shadow", "shape", "silence", "sky",
            "smoke", "snow", "snowflake", "sound", "star", "sun", "sun", "sunset",
            "surf", "term", "thunder", "tooth", "tree", "truth", "union", "unit",
            "violet", "voice", "water", "water", "waterfall", "wave", "wildflower", "wind",
            "wood"
    };
    private Random random = new Random();
    private String delimiter = "-";
    private String tokenChars = "0123456789";
    private int tokenLength = 4;
    private boolean tokenHex = false;

    public Haikunator() {
    }

    /**
     * Generate heroku-like random names
     *
     * @return String
     */
    public String haikunate() {
        if (tokenHex) {
            tokenChars = "0123456789abcdef";
        }

        String adjective = randomString(adjectives);
        String noun = randomString(nouns);

        StringBuilder token = new StringBuilder();
        if (tokenChars != null && tokenChars.length() > 0) {
            for (int i = 0; i < tokenLength; i++) {
                token.append(tokenChars.charAt(random.nextInt(tokenChars.length())));
            }
        }

        List<String> sections = new ArrayList<>(Arrays.asList(adjective, noun, token.toString()));
        sections.removeAll(Arrays.asList("", null));

        return String.join(delimiter, sections);
    }

    public String[] getAdjectives() {
        return adjectives;
    }

    public Haikunator setAdjectives(String[] adjectives) {
        this.adjectives = adjectives;
        return this;
    }

    public String[] getNouns() {
        return nouns;
    }

    public Haikunator setNouns(String[] nouns) {
        this.nouns = nouns;
        return this;
    }

    public Random getRandom() {
        return random;
    }

    public Haikunator setRandom(Random random) {
        this.random = random;
        return this;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public Haikunator setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    public String getTokenChars() {
        return tokenChars;
    }

    public Haikunator setTokenChars(String tokenChars) {
        this.tokenChars = tokenChars;
        return this;
    }

    public int getTokenLength() {
        return tokenLength;
    }

    public Haikunator setTokenLength(int tokenLength) {
        this.tokenLength = tokenLength;
        return this;
    }

    public boolean isTokenHex() {
        return tokenHex;
    }

    public Haikunator setTokenHex(boolean tokenHex) {
        this.tokenHex = tokenHex;
        return this;
    }

    /**
     * Random string from string array
     *
     * @param s Array
     * @return String
     */
    private String randomString(String[] s) {
        if (s == null || s.length <= 0) return "";
        return s[this.random.nextInt(s.length)];
    }
}
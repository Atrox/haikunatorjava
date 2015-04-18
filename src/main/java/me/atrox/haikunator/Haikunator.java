package me.atrox.haikunator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Haikunator {
    private Random rnd = new Random();
    private String[] ADJECTIVES = {
        "autumn", "hidden", "bitter", "misty", "silent", "empty", "dry", "dark",
        "summer", "icy", "delicate", "quiet", "white", "cool", "spring", "winter",
        "patient", "twilight", "dawn", "crimson", "wispy", "weathered", "blue",
        "billowing", "broken", "cold", "damp", "falling", "frosty", "green",
        "long", "late", "lingering", "bold", "little", "morning", "muddy", "old",
        "red", "rough", "still", "small", "sparkling", "throbbing", "shy",
        "wandering", "withered", "wild", "black", "young", "holy", "solitary",
        "fragrant", "aged", "snowy", "proud", "floral", "restless", "divine",
        "polished", "ancient", "purple", "lively", "nameless", "lucky", "odd", "tiny",
        "free", "dry", "yellow", "orange", "gentle", "tight", "super", "royal", "broad",
        "steep", "flat", "square", "round", "mute", "noisy", "hushy", "raspy", "soft",
        "shrill", "rapid", "sweet", "curly", "calm", "jolly", "fancy", "plain", "shinny"
    };
    private String[] NOUNS = {
        "waterfall", "river", "breeze", "moon", "rain", "wind", "sea", "morning",
        "snow", "lake", "sunset", "pine", "shadow", "leaf", "dawn", "glitter",
        "forest", "hill", "cloud", "meadow", "sun", "glade", "bird", "brook",
        "butterfly", "bush", "dew", "dust", "field", "fire", "flower", "firefly",
        "feather", "grass", "haze", "mountain", "night", "pond", "darkness",
        "snowflake", "silence", "sound", "sky", "shape", "surf", "thunder",
        "violet", "water", "wildflower", "wave", "water", "resonance", "sun",
        "wood", "dream", "cherry", "tree", "fog", "frost", "voice", "paper",
        "frog", "smoke", "star", "atom", "band", "bar", "base", "block", "boat",
        "term", "credit", "art", "fashion", "truth", "disk", "math", "unit", "cell",
        "scene", "heart", "recipe", "union", "limit", "bread", "toast", "bonus",
        "lab", "mud", "mode", "poetry", "tooth", "hall", "king", "queen", "lion", "tiger",
        "penguin", "kiwi", "cake", "mouse", "rice", "coke", "hola", "salad", "hat"
    };
    private final String delimiter;
    private String tokenChars;
    private final int tokenLength;
    private final boolean tokenHex;

    Haikunator(String delimiter, String tokenChars, int tokenLength, boolean tokenHex) {
        this.delimiter = delimiter;
        this.tokenChars = tokenChars;
        this.tokenLength = tokenLength;
        this.tokenHex = tokenHex;
    }

    /**
     * Generate Heroku-like random names
     * @return String
     */
    public String haikunate() {
        String adjective, noun, token = "";

        if (tokenHex) tokenChars = "0123456789abcdef";

        adjective = ADJECTIVES[rnd.nextInt(ADJECTIVES.length)];
        noun = NOUNS[rnd.nextInt(NOUNS.length)];

        for (int i = 0; i < tokenLength; i++) {
            token += tokenChars.charAt(rnd.nextInt(tokenChars.length()));
        }

        List<String> list = new ArrayList<String>(Arrays.asList(adjective, noun, token));
        list.removeAll(Arrays.asList("", null));

        return join(list, delimiter);
    }

    private static String join(List<String> list, String delim) {
        StringBuilder sb = new StringBuilder();
        String loopDelim = "";
        for(String s : list) {
            sb.append(loopDelim);
            sb.append(s);
            loopDelim = delim;
        }
        return sb.toString();
    }
}

class HaikunatorBuilder {
    private String delimiter = "-", tokenChars = "0123456789";
    private int tokenLength = 4;
    private boolean tokenHex = false;

    HaikunatorBuilder setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    HaikunatorBuilder setTokenChars(String tokenChars) {
        this.tokenChars = tokenChars;
        return this;
    }

    HaikunatorBuilder setTokenLength(int tokenLength) {
        this.tokenLength = tokenLength;
        return this;
    }

    HaikunatorBuilder setTokenHex(boolean tokenHex) {
        this.tokenHex = tokenHex;
        return this;
    }

    Haikunator build() {
        return new Haikunator(delimiter, tokenChars, tokenLength, tokenHex);
    }
}
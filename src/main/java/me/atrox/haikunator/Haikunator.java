package me.atrox.haikunator;

import org.apache.commons.lang3.StringUtils;

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
    private String delimiter;
    private int tokenLength;
    private boolean tokenHex;
    private String tokenChars;

    Haikunator(String delimiter, String tokenChars, int tokenLength, boolean tokenHex) {
        this.delimiter = delimiter;
        this.tokenChars = tokenChars;
        this.tokenLength = tokenLength;
        this.tokenHex = tokenHex;
    }

    Haikunator(HaikunatorBuilder builder) {
        this(builder.getDelimiter(), builder.getTokenChars(), builder.getTokenLength(), builder.isTokenHex());
    }

    public String[] getAdjectives() {
        return adjectives;
    }

    public void setAdjectives(String[] adjectives) {
        this.adjectives = adjectives;
    }

    public String[] getNouns() {
        return nouns;
    }

    public void setNouns(String[] nouns) {
        this.nouns = nouns;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
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

        String token = "";
        if (tokenChars.length() > 0) {
            for (int i = 0; i < tokenLength; i++) {
                token += tokenChars.charAt(random.nextInt(tokenChars.length()));
            }
        }

        List<String> sections = new ArrayList<String>(Arrays.asList(adjective, noun, token));
        sections.removeAll(Arrays.asList("", null));

        return StringUtils.join(sections, delimiter);
    }

    /**
     * Random string from string array
     *
     * @param s Array
     * @return String
     */
    private String randomString(String[] s) {
        int length = s.length;
        if (length <= 0) return "";

        return s[random.nextInt(length)];
    }
}
package me.atrox.haikunator;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Haikunator {
    private static Random rnd = new Random();
    private static String[] ADJECTIVES = {
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
    private static String[] NOUNS = {
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

    /**
     * Generate Heroku-like random names
     * @param params Parameters as Map
     * @return String
     */
    public static String haikunate(Map<String, Object> params) {
        String delimiter = "-", tokenChars = "0123456789";
        int tokenLength = 4;
        boolean tokenHex = false;

        if (params.containsKey("delimiter")) {
            if (!(params.get("delimiter") instanceof String)) {
                throw new IllegalArgumentException("...");
            }
            delimiter = (String)params.get("delimiter");
        }
        if (params.containsKey("tokenChars")) {
            if (!(params.get("tokenChars") instanceof String)) {
                throw new IllegalArgumentException("...");
            }
            tokenChars = (String)params.get("tokenChars");
        }
        if (params.containsKey("tokenLength")) {
            if (!(params.get("tokenLength") instanceof Integer)) {
                throw new IllegalArgumentException("...");
            }
            tokenLength = (Integer)params.get("tokenLength");
        }
        if (params.containsKey("tokenHex")) {
            if (!(params.get("tokenHex") instanceof Boolean)) {
                throw new IllegalArgumentException("...");
            }
            tokenHex = (Boolean)params.get("tokenHex");
        }

        if (tokenHex) tokenChars = "0123456789abcdef";

        String adjective = ADJECTIVES[rnd.nextInt(ADJECTIVES.length)];
        String noun = NOUNS[rnd.nextInt(NOUNS.length)];
        String token = "";

        for (int i = 0; i < tokenLength; i++) {
            token += tokenChars.charAt(rnd.nextInt(tokenChars.length()));
        }

        List<String> list = new ArrayList<String>(Arrays.asList(adjective, noun, token));
        list.removeAll(Arrays.asList("", null));

        return StringUtils.join(list, delimiter);
    }
}
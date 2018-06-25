package org.khwu._535_encode_and_decode_tinyurl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {

    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String CODE = "abcdefghijklmnipqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_BASE = 62;
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = longToShort.get(longUrl);
        if (shortUrl != null) return shortUrl;

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        do {
            sb.setLength(BASE_URL.length());
            for (int i = 0; i < 6; i++) {
                int idx = rand.nextInt(CODE_BASE);
                sb.append(CODE.charAt(idx));
            }
        } while (shortToLong.containsKey(sb.toString()));
        shortUrl = sb.toString();
        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);
        return BASE_URL + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

package com.example.socr11.link.service;

import java.util.Random;

import java.security.SecureRandom;
import java.util.Base64;

public class LinkShortener { //алгоритм Base64

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 10;

    public static String shortenLink(String originalLink) {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[LENGTH];
        random.nextBytes(randomBytes);
        String base64 = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            char c = base64.charAt(i);
            int index = c % ALPHABET.length();
            sb.append(ALPHABET.charAt(index));
        }

        return sb.toString();
    }
}



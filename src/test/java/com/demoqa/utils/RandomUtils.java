package com.demoqa.utils;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.bytebuddy.utility.RandomString;

public class RandomUtils {
    public static String getRandomString(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static String getRandomEmail(int length) {
        return getRandomString(length) + "@mail.com";
    }

    public static Long getRandomLong(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
    public static String getRandomPhone(){
        return getRandomLong(1111111111L,9999999999L).toString();
    }
}

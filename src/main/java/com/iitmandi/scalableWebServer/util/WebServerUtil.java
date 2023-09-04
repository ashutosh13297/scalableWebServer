package com.iitmandi.scalableWebServer.util;

import java.util.Random;

public class WebServerUtil {

    private static Random random = new Random();
    private static final int INT_BOUND = 100000;

    public static Integer getRandomNumber() {
        return random.nextInt(INT_BOUND);
    }
}

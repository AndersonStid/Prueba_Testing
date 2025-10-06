package com.prueba.certificacion.api.utils.templates;

import com.google.common.net.InetAddresses;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class GenerateData {
    private GenerateData() {
    }

    public static String ip() {
        return InetAddresses.fromInteger(new Random().nextInt()).getHostAddress();
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String getRandomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String getTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
    }
}
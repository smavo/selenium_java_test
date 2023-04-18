package org.selenium.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.BillingAdress02;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static <T> T deserializeJson(String filename, Class<T> T) throws IOException {
        InputStream filepath = JacksonUtils.class.getClassLoader().getResourceAsStream(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(filepath, T );
    }

    /*public static BillingAdress02 deserializeJson(InputStream filepath, BillingAdress02 billingAdress02) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(filepath, billingAdress02.getClass());
    }*/
}

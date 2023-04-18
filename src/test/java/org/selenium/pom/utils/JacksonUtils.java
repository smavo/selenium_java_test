package org.selenium.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.BillingAdress02;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static BillingAdress02 deserializeJson(InputStream filepath, BillingAdress02 billingAdress02) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(filepath, billingAdress02.getClass());
    }

}

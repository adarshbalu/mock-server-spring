package com.example.mockserverspring.utils;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperUtil {
    private HelperUtil() {
    }

    public static List<Mock> mockSupplier() {
        Map<String, Object> hashMap = new HashMap<String, Object>();
        Map<String, String> stringMap = new HashMap<String, String>();
        Request request = new Request(200, "GET", "/status", "newMock", hashMap, hashMap, stringMap);
        return List.of(
                new Mock("20", "mock1", List.of(request))
        );
    }

    public static Mock supplySingleMock() {
        Map<String, String> stringMap = new HashMap<String, String>();
        Map<String, Object> hashMap = new HashMap<String, Object>();
        Request request = new Request(200, "GET", "/status", "newMock", hashMap, hashMap, stringMap);
        return
                new Mock("10", "mock1", List.of(request))
                ;
    }
}


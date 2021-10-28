package com.example.mockserverspring.utils;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;

import java.util.HashMap;
import java.util.List;

public class HelperUtil {
    private HelperUtil() {
    }

    public static List<Mock> mockSupplier() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Request request = new Request(200, "GET", "/status", "newMock", hashMap, hashMap, hashMap);
        return List.of(
                new Mock("20", "mock1", List.of(request))
        );
    }

    public static Mock supplySingleMock() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Request request = new Request(200, "GET", "/status", "newMock", hashMap, hashMap, hashMap);
        return
                new Mock("10", "mock1", List.of(request))
                ;
    }
}


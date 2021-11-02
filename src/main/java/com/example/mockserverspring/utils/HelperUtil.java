package com.example.mockserverspring.utils;

import com.example.mockserverspring.models.Mock;
import com.example.mockserverspring.models.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperUtil {
    private HelperUtil() {
    }

    public static Mock supplySingleMock() {
        Map<String, String> stringMap = new HashMap<String, String>();
        Map<String, Object> hashMap = new HashMap<String, Object>();
        Request request = new Request(200, "GET", "status", "newMock", hashMap, hashMap, stringMap);
        return
                new Mock("10", "newMock", List.of(request))
                ;
    }
}


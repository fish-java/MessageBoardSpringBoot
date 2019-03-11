package com.github.zhang89.messageboardsbjdbc.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
    private static ObjectMapper mapper = new ObjectMapper();
    public static String getJSONStringFromObj(Object obj)
      throws JsonProcessingException {
        return  mapper.writeValueAsString(obj);
    }
}

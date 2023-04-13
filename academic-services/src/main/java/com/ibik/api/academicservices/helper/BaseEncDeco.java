package com.ibik.api.academicservices.helper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

public class BaseEncDeco {
    public List<String> Decoded(String token) throws UnsupportedEncodingException, Exception {
        String[] parts = token.split("\\.");
        String header = new String(Base64.decodeBase64(parts[0]), "UTF-8");
        String payload = new String(Base64.decodeBase64(parts[1]), "UTF-8");
        List<String> result = new ArrayList<String>();
        result.add(header);
        result.add(payload);
        return result;
    }
}

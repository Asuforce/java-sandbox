package com.example;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws JsonProcessingException {
        Hoge hoge = new Hoge();
        hoge.id = 10;
        hoge.name = "hoge";

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hoge);

        System.out.println(json);

        String parent = "{\"id\":20, \"name\":\"HOGE\"}";

        try {
            Hoge fuga = mapper.readValue(parent, Hoge.class);
            System.out.println(fuga);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpClient httpClient = new HttpClient();
        httpClient.getSample();
        httpClient.postSample();
    }
}

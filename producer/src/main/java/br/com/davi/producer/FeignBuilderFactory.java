package br.com.davi.producer;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class FeignBuilderFactory {

    private static final String BASE_URL = "https://viacep.com.br/ws";

    public static <T> T createClient(Class<T> type) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(feign.Logger.Level.FULL)
                .target(type, BASE_URL);
    }

}
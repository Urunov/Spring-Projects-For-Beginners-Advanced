package com.example.moneysecureauthflux.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfigData {

    private Pass password;
    private Jjwt jjwt;

    @Data
    public static class Pass {

        private Encode encode;

        @Data
        public static class Encode {
            private String secret;
            private int iteration;
            private int keyLength;
        }

    }

    @Data
    public static class Jjwt {
        private String secret;
        private long expiration;
    }
}

package uz.edu.client.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @project: RestTemplateStackAPI
 * @Date: 18.10.2022
 * @author: H_Urunov
 **/
@Configuration
public class RestTemplateConfiguration {
    //
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}

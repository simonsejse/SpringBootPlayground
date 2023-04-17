package com.simonwinther.Refresh.runners;

import com.simonwinther.Refresh.QuoteController;
import com.simonwinther.Refresh.dao.StudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CmdLineRunner {
    private static final Logger log = LoggerFactory.getLogger(CmdLineRunner.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate){
        return args -> {
            QuoteController.Quote quote = restTemplate.getForObject("http://localhost:8080/quote/random", QuoteController.Quote.class);
            assert quote != null;
            log.info("Working with microservices it's really good to retrieve objects from endpoints:");
            log.info(quote.toString());
        };
    }



}

package app;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = Logger.getLogger("ConsumingRestApplication");

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

        Properties props = System.getProperties();
        props.put("https.proxyHost", "172.17.12.36");
        props.put("https.proxyPort", "8080");
        return args -> {
            // Quote quote = restTemplate.getForObject(
            // "https://quoters.apps.pcfone.io/api/random", Quote.class);
            String quote = restTemplate.getForObject(
                    "https://quoters.apps.pcfone.io/api/random", String.class);
            log.info(quote.toString());
        };
    }
}
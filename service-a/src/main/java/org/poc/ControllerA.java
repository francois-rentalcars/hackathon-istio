package org.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ControllerA {

    private static Logger log = LoggerFactory.getLogger(ControllerA.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @GetMapping("/foo")
    public String foo() {
        log.info("Handling request for /foo");
        String response = restTemplate.getForObject("http://localhost:8181/bar", String.class);
        log.info("Returning response for /foo");
        return response;
    }

    @GetMapping("/foo-async")
    public Mono<String> fooAsync() {
        log.info("Handling request for /foo-async");
        return webClient.get()
                .uri("http://localhost:8181/bar")
                .exchange()
                .flatMap(response -> {
                    log.info("Returning response for /foo-async");
                    return response.bodyToMono(String.class);
                });
    }

}

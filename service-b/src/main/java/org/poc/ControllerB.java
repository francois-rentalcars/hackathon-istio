package org.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerB {

    private static Logger log = LoggerFactory.getLogger(ControllerB.class);

    @GetMapping("/bar")
    public String bar() {
        log.info("Handling request for /bar");
        return "value";
    }

}

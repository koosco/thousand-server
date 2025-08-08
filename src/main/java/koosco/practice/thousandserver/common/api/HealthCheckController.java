package koosco.practice.thousandserver.common.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class HealthCheckController {

    @GetMapping("/api/health")
    public String helloword() {
        log.info("/api/health called");
        return "Hello world";
    }

    @GetMapping("/health")
    public String healthCheck() {
        log.info("/health called");
        return "OK";
    }
}

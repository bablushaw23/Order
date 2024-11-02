package org.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<String> ping() {
//        log.info("Handling /order request - Trace ID: {}, Span ID: {}", tracer.currentSpan().context().traceId(), tracer.currentSpan().context().spanId());
//        log.info("Call reached");
        callPayment();
        return ResponseEntity.ok("call reached");
    }

    private void callPayment() {
        log.info("Calling payment service:{}",restTemplate.getForObject("http://localhost:8081/payment",String.class));
    }
}

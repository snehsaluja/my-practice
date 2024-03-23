package com.practice.mypractice.learningwebflux;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/flux")
public class FluxController {

    @GetMapping(value = "/data/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> streamData() {
        return Flux.range(0, 100).delayElements(Duration.ofSeconds(1));
    }


}

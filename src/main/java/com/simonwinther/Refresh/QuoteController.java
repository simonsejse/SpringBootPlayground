package com.simonwinther.Refresh;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller

@ResponseBody
public class QuoteController {

    private final AtomicLong counter = new AtomicLong(0);

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Quote(String type, Value value){}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Value(Long id, String quote) {}

    @RequestMapping(method = RequestMethod.GET, value = "/quote/random")
    public Quote quoteEndpoint(){
        return new Quote("comedy", new Value(counter.incrementAndGet(), "If being a duck is a duck then duck"));
    }

}

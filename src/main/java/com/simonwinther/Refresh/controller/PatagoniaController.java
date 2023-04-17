package com.simonwinther.Refresh.controller;

import io.vavr.control.Option;
import okhttp3.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatagoniaController {

    private String fetchPatagoniaData(){
        return Option.of("https://www.patagonia.com/session/")
                .map(new Request.Builder()::url)
                .map(Request.Builder::build)
                .map(new OkHttpClient()::newCall)
                .toTry()
                .mapTry(Call::execute)
                .mapTry(Response::body)
                .mapTry(ResponseBody::string)
                .getOrElse(String::new);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            path="/api/patagonia"
    )
    public String ForwardDataFromPatagonia(){
        var data = fetchPatagoniaData();
        return (data.isEmpty() || data.isBlank()) ? "Data could not be fetched!" : data;
    }
}

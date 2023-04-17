package com.simonwinther.Refresh.controller;

import com.simonwinther.Refresh.dto.ShortUrlDTO;
import com.simonwinther.Refresh.service.ShortUrlService;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping(
        path = "/api/createUrl"
    )
    public ShortUrlDTO createUrl(@RequestParam String slug, @RequestParam String redirectUrl){
        return shortUrlService.createShortenedUrl(slug, redirectUrl);
    }


    @GetMapping(path = "/goto/{slug}")
    public RedirectView redirectBy(@PathVariable String slug){
        return shortUrlService.redirectBySlug(slug);
    }
}

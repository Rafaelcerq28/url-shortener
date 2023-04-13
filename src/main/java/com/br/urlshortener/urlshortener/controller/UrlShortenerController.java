package com.br.urlshortener.urlshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.urlshortener.urlshortener.model.Address;
import com.br.urlshortener.urlshortener.service.UrlShortenerService;

@RestController

public class UrlShortenerController {
    
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    private UrlShortenerService urlShortenerService;

    @PostMapping("/generator")
    @ResponseStatus(HttpStatus.CREATED)
    public Address createShortenedUrl(@RequestBody Address url){
        return urlShortenerService.createShortenedUrl(url);
    }

}

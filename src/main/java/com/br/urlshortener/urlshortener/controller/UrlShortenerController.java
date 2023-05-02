package com.br.urlshortener.urlshortener.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.tomcat.util.buf.UriUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{shortenedUrl}")
    public ResponseEntity<Address> getOriginalUrl(@PathVariable(value = "shortenedUrl") String shortenedUrl){
        
        final String HTTP_PREFIX = "http://";
        final String HTTPS_PREFIX = "https://";

        Address url = urlShortenerService.getOriginalUrl(shortenedUrl);

        if(url == null){
            System.out.println("object null");
            return ResponseEntity.notFound().build();
        }

        String redirect = url.getUrlOriginal();

        if (!redirect.substring(0, HTTP_PREFIX.length()).equals(HTTP_PREFIX) &&
				!redirect.substring(0, HTTPS_PREFIX.length()).equals(HTTPS_PREFIX)) {
			redirect = HTTP_PREFIX.concat(redirect);
		}
   
        try {
            URI uri = new URI(redirect);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uri);
            //System.out.println("ok");
            return new ResponseEntity<>(httpHeaders,HttpStatus.SEE_OTHER);

        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println("Url error");
            return ResponseEntity.notFound().build();
            
        }
    }

}



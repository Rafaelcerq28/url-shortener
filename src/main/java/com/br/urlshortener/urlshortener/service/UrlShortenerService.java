package com.br.urlshortener.urlshortener.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.urlshortener.urlshortener.model.Address;
import com.br.urlshortener.urlshortener.repository.UrlShortenerRepository;

@Service
public class UrlShortenerService {
    
    
    public UrlShortenerService(UrlShortenerRepository urlShortenerRepository) {
        this.urlShortenerRepository = urlShortenerRepository;
    }

    private UrlShortenerRepository urlShortenerRepository;

    /* 
     * This method create a shortened URL based on ID
     */
    public Address createShortenedUrl(Address url){
        
        url = urlShortenerRepository.save(url);        
        url.setUrlShortened(url.generateShortUrl(url.getId()));

        return urlShortenerRepository.save(url);
    }

    public Address getOriginalUrl(String urlShortened){

        Optional<Address> url = urlShortenerRepository.findByurlShortened(urlShortened);

        //to do
        //implement click counter method

        return url.orElse(null);
    }

}

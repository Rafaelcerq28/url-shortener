package com.br.urlshortener.urlshortener.service;

import org.springframework.stereotype.Service;

import com.br.urlshortener.urlshortener.model.Address;
import com.br.urlshortener.urlshortener.repository.UrlShortenerRepository;

@Service
public class UrlShortenerService {
    
    
    public UrlShortenerService(UrlShortenerRepository urlShortenerRepository) {
        this.urlShortenerRepository = urlShortenerRepository;
    }

    private UrlShortenerRepository urlShortenerRepository;

    public Address createShortenedUrl(Address url){
        
        url = urlShortenerRepository.save(url);        
        url.setUrlShortened(url.generateShortUrl(url.getId()));

        return urlShortenerRepository.save(url);
    }


}

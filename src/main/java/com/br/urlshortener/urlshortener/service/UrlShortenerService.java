package com.br.urlshortener.urlshortener.service;

import java.util.Optional;

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

    /* 
     * This method get the original URL and update click counter
     */
    public Address getOriginalUrl(String urlShortened){

        Optional<Address> url = urlShortenerRepository.findByurlShortened(urlShortened);

        //Click counter
        try {
            //set Optional URL into address
            Address updateAddress = url.get();
            //Update click counter
            updateAddress.setClickCounter(updateAddress.getClickCounter() + 1);
            //save
            urlShortenerRepository.save(updateAddress);
            //System.out.println(updateAddress.getClickCounter());
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        return url.orElse(null);
    }

}

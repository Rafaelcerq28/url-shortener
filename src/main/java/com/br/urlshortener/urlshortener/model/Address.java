package com.br.urlshortener.urlshortener.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="url")
public class Address {
    
    public Address() {
    }

    public Address(String urlOriginal, String urlShortened) {
        this.urlOriginal = urlOriginal;
        this.urlShortened = urlShortened;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @JsonProperty("link")
    private String urlOriginal;
    
    @Column
    private int clickCounter;

    @Column
    private String urlShortened;

    @CreationTimestamp
    private Instant createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlShortened() {
        return urlShortened;
    }

    public void setUrlShortened(String urlShortened) {
        this.urlShortened = urlShortened;
    }

    public int getClickCounter() {
        return clickCounter;
    }

    public void setClickCounter(int clickCounter) {
        this.clickCounter = clickCounter;
    }

    public String generateShortUrl(int id){
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
     
        StringBuffer shorturl = new StringBuffer();
     
        // Convert given integer id to a base 62 number
        while (id > 0)
        {
            // use above map to store actual character
            // in short url
            shorturl.append(map[id % 62]);
            id = id / 62;
        }

        for(int i = 0;i<6; i++){
            char sequence[] = "2SOtPx".toCharArray();
            
            shorturl.append(sequence[i]);

        }
        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }

}

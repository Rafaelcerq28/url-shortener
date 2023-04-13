package com.br.urlshortener.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.urlshortener.urlshortener.model.Address;

public interface UrlShortenerRepository extends JpaRepository<Address,Integer>{
    
}

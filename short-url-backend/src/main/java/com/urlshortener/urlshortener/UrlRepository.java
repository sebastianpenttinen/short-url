package com.urlshortener.urlshortener;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlRepository extends MongoRepository<ShortUrl, String> {
    Optional<ShortUrl> findByShortUrl(String url);
}

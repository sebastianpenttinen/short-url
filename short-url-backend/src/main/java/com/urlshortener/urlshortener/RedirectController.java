package com.urlshortener.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/go")
public class RedirectController {

    @Autowired
    UrlRepository repository;

    @RequestMapping(path = "/{url}", method = RequestMethod.GET)
    public ResponseEntity<Object> navigate(@PathVariable("url") String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        repository.findByShortUrl(url).ifPresent(shortUrl -> {
            try {
                httpHeaders.setLocation(new URI(shortUrl.getFullUrl()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
}

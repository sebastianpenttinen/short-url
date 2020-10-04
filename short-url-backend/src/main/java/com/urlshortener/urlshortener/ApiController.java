package com.urlshortener.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class ApiController {

    @Autowired
    UrlRepository repository;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<ShortUrl>> listUrl() {
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveNewUrl(@RequestBody ShortUrl shortUrl) {

        if(repository.findByShortUrl(shortUrl.getShortUrl()).isPresent()){
            return ResponseEntity.status(400).body("Short url already taken");
        }

        repository.save(shortUrl);
        return ResponseEntity.status(201).build();
    }
}

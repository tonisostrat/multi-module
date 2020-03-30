package org.example.web;

import org.example.core.CoreService;
import org.example.data.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RootController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final CoreService core;

    RootController(CoreService core) {
        log.info(getClass() + " initialized");

        this.core = core;
    }

    @GetMapping
    ResponseEntity<List<Message>> root() {
        log.info("GET /");

        return ResponseEntity.ok(this.core.getAllMessages());
    }

    @GetMapping("/{id}")
    ResponseEntity<Message> find(@PathVariable Long id) {
        log.info("GET /{}", id);

        return core.getMessage(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Message> create(@RequestParam String content) {
        log.info("POST /?content={}", content);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.core.createMessage(content));
    }
}

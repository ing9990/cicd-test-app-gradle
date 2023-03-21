package com.cicdtestappgradle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestApi {

    private String message = "hello world";

    @GetMapping
    public ResponseEntity<?> getTestMessage() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("".equals(message) ? "helloworld" : message);
    }

    @PostMapping("/{message}")
    public ResponseEntity<Void> setTestMessage(
            @PathVariable String message
    ) {
        this.message = message;

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTestMessage() {
        this.message = "";
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

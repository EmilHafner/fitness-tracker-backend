package com.example.fitnesstrackerbackend.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test-controller")
public class testController {

  @GetMapping
  public ResponseEntity<String> helloWorld() {
    return ResponseEntity.ok("Hello World. Sent from secured endpoint");
  }
}

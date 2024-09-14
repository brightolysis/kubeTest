package com.imprint.kubernetesdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class KubeController {
    @GetMapping("/test")
    public ResponseEntity<String> greet(){
        return new ResponseEntity<>("hello my first kubernetes project", HttpStatus.OK);
    }
}

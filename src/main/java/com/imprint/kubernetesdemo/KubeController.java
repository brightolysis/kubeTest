package com.imprint.kubernetesdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class KubeController {
    @Value("${CLOUD_PASSWORD}")
    private String password;
    @GetMapping("/test")
    public ResponseEntity<String> greet(){
        String message = String.format("my test password %s",this.password);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

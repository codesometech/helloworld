package com.demo.helloworld;

import java.net.InetAddress;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String greeting() {
        return "Hello World! Try calling /whoami ";
    }
    @GetMapping("/whoami")
    public String getDateTime() {
        String ipaddress = null;
        try {
            ipaddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            ipaddress = "anonymous";
        }
        return "I am " + ipaddress + ". Current time here is " + new Date(System.currentTimeMillis()).toString();
    }

    @GetMapping("/listHeaders")
    public ResponseEntity<String> listAllHeaders(
            @RequestHeader Map<String, String> headers) {
        StringBuffer header = new StringBuffer();
        headers.forEach((key, value) -> {
            header.append(String.format("Header '%s' = %s", key, value));
            header.append("<br>");
            header.append(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<String>(header.toString(), HttpStatus.OK);
    }

    @GetMapping("/passcode")
    public String getPasscode() {
        String passcode = null;
        try {
            passcode = System.getenv("PASSCODE");
        } catch (Exception e) {
            passcode = "no passcode for you";
        }
        return passcode;
    }
}

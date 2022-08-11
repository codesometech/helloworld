package com.demo.helloworld;

import java.net.InetAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.Date;

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

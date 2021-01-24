package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class UiController {

    private final RestTemplate restTemplate;
    private static final String protocol = "http://";
    private static final String ingresshost = "hashicorpx.ingress.dc-1.consul:8080";

    public UiController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Value( "${ingress_url}" )
    private String ingress_url;

    @GetMapping(value = "/japan")
    public String japan(Model model) {
        ResponseEntity<String> response =
                this.restTemplate.exchange(protocol + ingress_url + "/japan",
                        HttpMethod.GET,
                        new HttpUtil().setEntiry(ingresshost),
                        String.class);
        model.addAttribute("message", response.getBody() + " 🇯🇵");
        return "ui/index";
    }

    @GetMapping(value = "/france")
    public String france(Model model) {
        ResponseEntity<String> response =
                this.restTemplate.exchange(protocol + ingress_url + "/france",
                        HttpMethod.GET,
                        new HttpUtil().setEntiry(ingresshost),
                        String.class);
        model.addAttribute("message", response.getBody() + " 🇫🇷");
        return "ui/index";
    }

}

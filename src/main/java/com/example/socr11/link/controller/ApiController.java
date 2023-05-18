package com.example.socr11.link.controller;

import com.example.socr11.link.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final LinkService service;

    @PostMapping(path = "link")
    public PostResponse postLink(
            @RequestBody PostRequest request
    ) {
        return new PostResponse(service.postShortLink(request.getLink()));
    }

    @GetMapping(path = "link/{linkShort}")
    public RedirectView getLink(
            @PathVariable String linkShort) {
        return new RedirectView(service.getGivenLink(linkShort));
    }

    @GetMapping(path = "helloworld")
    public String sayHelloWorld() {
        return
                "<!DOCTYPE html>"+
                        "<html>"+
                        "	<head><body>Hello world!</body></head>"+
                        "</html>"
                ;
    }
}

package com.example.socr11.link.service;

import com.example.socr11.link.Link;
import com.example.socr11.link.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository repository;

    public String postShortLink(String linkGiven) {
        Optional<Link> link = repository.findByLinkGiven(linkGiven);
        if (link.isPresent()) return link.get().getLinkShort();
        else {
            Link newLink = new Link();
            newLink.setLinkGiven(linkGiven);
            newLink.setLinkShort(LinkShortener.shortenLink(linkGiven));
            repository.save(newLink);
            return newLink.getLinkShort();
        }
    }

    public String getGivenLink(String linkShort) {
        Optional<Link> link = repository.findByLinkShort(linkShort);
        if (link.isPresent()) return link.get().getLinkGiven();
        else throw new IllegalStateException("Wrong URL");
    }
}

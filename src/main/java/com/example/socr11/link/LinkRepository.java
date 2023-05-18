package com.example.socr11.link;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository
        extends JpaRepository <Link, Long> {
    Optional<Link> findByLinkGiven(String linkGiven);
    Optional<Link> findByLinkShort(String linkShort);
}

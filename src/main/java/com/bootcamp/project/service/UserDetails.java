package com.bootcamp.project.service;

import com.bootcamp.project.repos.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetails{
    private final UserDetailsRepository userDetailsRepository;
}

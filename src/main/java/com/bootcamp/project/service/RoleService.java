package com.bootcamp.project.service;

import com.bootcamp.project.model.Role;
import com.bootcamp.project.repos.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public Role addRole(Role role){ return roleRepository.save(role); }
}
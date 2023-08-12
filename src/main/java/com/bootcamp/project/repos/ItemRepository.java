package com.bootcamp.project.repos;

import com.bootcamp.project.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

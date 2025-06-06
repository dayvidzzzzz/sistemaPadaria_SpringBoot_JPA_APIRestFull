package com.DySistemas.SistemaPadariaOnline.repository;

import com.DySistemas.SistemaPadariaOnline.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}

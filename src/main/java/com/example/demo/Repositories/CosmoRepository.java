package com.example.demo.Repositories;
import com.example.demo.JBCStore.Cosmetics;

import org.springframework.data.repository.CrudRepository;

public interface CosmoRepository extends CrudRepository<Cosmetics,Long> {
}

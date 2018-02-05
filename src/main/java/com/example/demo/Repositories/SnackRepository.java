package com.example.demo.Repositories;
import com.example.demo.JBCStore.Snacks;

import org.springframework.data.repository.CrudRepository;


public interface SnackRepository extends CrudRepository<Snacks, Long> {
}

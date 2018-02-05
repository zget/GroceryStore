package com.example.demo.Repositories;

import com.example.demo.JBCStore.CleaningItems;
import org.springframework.data.repository.CrudRepository;

public interface CleanRepository extends CrudRepository<CleaningItems,Long> {
}

package ru.willshamin.partlist.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.willshamin.partlist.entities.Part;

import java.util.List;

public interface PartRepository extends CrudRepository<Part, Integer> {
    Page<Part> findByNameContainsIgnoreCase(String name, Pageable pageable);
    Page<Part> findAll(Pageable pageable);
    List<Part> findAll();
}


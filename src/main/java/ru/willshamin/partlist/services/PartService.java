package ru.willshamin.partlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.willshamin.partlist.entities.Part;
import ru.willshamin.partlist.repositories.PartRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PartService {
    @Autowired
    private PartRepository partRepository;

    public int getNumberOfComputers() {
        List<Part> partList = partRepository.findAll();
        int number = 0;
        int stock = 0;
        for (Part part : partList) {
            if (part.isRequired()) {
                stock = part.getStock();
                if (number == 0)
                    number = stock;
                else
                    if (number > stock)
                        number = stock;
            }
        }
        return number;
    }

    public void delete(Integer id) {
        Part user = findById(id);
        if (user != null)
            partRepository.delete(user);
    }

    public void save(Part user) {
        partRepository.save(user);
    }

    public Part findById(Integer id) {
        Part user = null;
        Optional<Part> optional = partRepository.findById(id);
        if (optional.isPresent())
            user = optional.get();
        return user;
    }

    public Page<Part> findByName(String name, Pageable pageable) {
        return partRepository.findByNameContainsIgnoreCase(name, pageable);
    }

    public Page<Part> findAll(Pageable pageable) {
        return partRepository.findAll(pageable);
    }
}

package ru.willshamin.partlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.willshamin.partlist.entities.Part;
import ru.willshamin.partlist.services.PartService;

import java.util.Calendar;

@Controller
public class PartController {
    @Autowired
    private PartService partService;

    @GetMapping("/")
    public String list(@RequestParam(required = false, defaultValue = "") String filter,
                       @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
                       Model model) {
        Page<Part> parts;
        if (filter != null && !filter.isEmpty())
            parts = partService.findByName(filter, pageable);
        else
            parts = partService.findAll(pageable);
        model.addAttribute("parts", parts);
        model.addAttribute("number", partService.getNumberOfComputers());
        if (filter != null && !filter.isEmpty())
            model.addAttribute("filter", filter);
        return "list";
    }

    @GetMapping("/new")
    public String create(Part part) {
        return "new";
    }

    @PostMapping("/new")
    public String saveAfterCreate(Part part) {
        part.setDate(Calendar.getInstance().getTime());
        partService.save(part);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Part part = partService.findById(id);
        model.addAttribute(part);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveAfterEdit(Part part) {
        partService.save(part);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        partService.delete(id);
        return "redirect:/";
    }
}

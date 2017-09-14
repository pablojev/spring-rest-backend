package pl.pawel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pawel.entity.Specie;
import pl.pawel.repository.SpecieRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by pablojev on 26.07.2017.
 */

@CrossOrigin
@RestController
@RequestMapping("/species")
public class SpecieController {

    @Autowired
    private SpecieRepository specieRepository;

    @RequestMapping("/add")
    public Specie add(@RequestParam(name = "name") String name,
                      @RequestParam(name = "description") String description) {
        Specie s = new Specie();
        s.setName(name);
        s.setDescription(description);
        return specieRepository.save(s);
    }

    @RequestMapping("/show")
    public List<Specie> showAll() {
        return (List<Specie>) specieRepository.findAll();
    }

    @RequestMapping("/show/{id}")
    public Specie showById(@PathVariable(name = "id") String id) {
        long myId = Long.valueOf(id);
        return specieRepository.findOne(myId);
    }
}

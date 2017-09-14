package pl.pawel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pawel.entity.Animal;
import pl.pawel.entity.Specie;
import pl.pawel.repository.AnimalRepository;
import pl.pawel.repository.SpecieRepository;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SpecieRepository specieRepository;

    @RequestMapping("/")
    public String animal() {
        return "";
    }

    @RequestMapping("/show")
    public List<Animal> listAnimals() {
        return (List<Animal>) animalRepository.findAll();
    }

    @RequestMapping("/add")
    public Animal addAnimal(@RequestParam(name = "name") String name,
                            @RequestParam(name = "description") String desc,
                            @RequestParam(name = "image") String image,
                            @RequestParam(name = "specie") String specie) {
        long specieId = Long.valueOf(specie);
        Specie s = specieRepository.findOne(specieId);
        Animal a = new Animal();
        a.setName(name);
        a.setDescription(desc);
        a.setImage(image);
        a.setSpecie(s);
        return animalRepository.save(a);
    }

    @RequestMapping("/show/{id}")
    public Animal showAnimalByID(@PathVariable("id") String id) {
        return animalRepository.findOne(Long.valueOf(id));
    }

    @RequestMapping("/delete/{id}")
    public boolean deleteAnimal(@PathVariable("id") String id) {
        long myId = Long.valueOf(id);
        Animal a = animalRepository.findOne(myId);
        a.setSpecie(null);
        animalRepository.delete(a);
        return true;
    }

    @RequestMapping("/edit")
    public Animal editAnimal(@RequestParam(name = "id") String id,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "description") String desc,
                             @RequestParam(name = "image") String image,
                             @RequestParam(name = "specie") String specie) {
        long myId = Long.valueOf(id);
        long specieId = Long.valueOf(specie);
        Specie s = specieRepository.findOne(specieId);
        Animal a = new Animal();
        a.setId(myId);
        a.setName(name);
        a.setDescription(desc);
        a.setImage(image);
        a.setSpecie(s);
        return animalRepository.save(a);
    }
}

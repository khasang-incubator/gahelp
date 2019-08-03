package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Character;
import io.khasang.gahelp.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/character")
public class CharacterController {
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Character addCharacter(@RequestBody Character character) {
        return characterService.add(character);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Character deleteById(@PathVariable("id") long id) {
        return characterService.deleteById(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Character getById(@PathVariable("id") long id) {
        return characterService.getById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Character updateById(@PathVariable("id") long id, @RequestBody Character character) {
        return characterService.updateById(character, id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Character> getAll() {
        return characterService.getAll();
    }
}

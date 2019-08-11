package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Characters;
import io.khasang.gahelp.service.CharactersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/characters")
public class CharactersController {
    private CharactersService charactersService;

    public CharactersController(CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Characters addCharacters(@RequestBody Characters characters) {
        return charactersService.add(characters);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Characters deleteById(@PathVariable("id") long id) {
        return charactersService.deleteById(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Characters getById(@PathVariable("id") long id) {
        return charactersService.getById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Characters update(@RequestBody Characters characters) {
        return charactersService.update(characters);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Characters> getAll() {
        return charactersService.getAll();
    }
}

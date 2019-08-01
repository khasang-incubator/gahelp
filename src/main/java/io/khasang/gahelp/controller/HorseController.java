package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Horse;
import io.khasang.gahelp.service.HorseService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/horse")
public class HorseController {

    private final HorseService horseService;

    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Horse addHorse(@RequestBody Horse horse) {
        return horseService.add(horse);
    }

//    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Horse getHorseById(@PathVariable("id") long id) {
        return horseService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Horse> getAll() {
        return horseService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Horse deleteHorse(@PathVariable("id") long id) {
        return horseService.delete(id);
    }

}

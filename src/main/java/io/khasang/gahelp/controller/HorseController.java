package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Horse;
import io.khasang.gahelp.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/horse")
public class HorseController {

    private HorseService horseService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Horse addHorse(@RequestBody Horse horse) {
        return horseService.add(horse);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Horse getHorseById(@PathVariable("id") long id) {
        return horseService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Horse> getAll(){
        return horseService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Horse deleteHorse(@PathVariable("id") long id) {
        return horseService.delete(id);
    }

    @Autowired
    public void setHorseService(HorseService horseService) {
        this.horseService = horseService;
    }
}

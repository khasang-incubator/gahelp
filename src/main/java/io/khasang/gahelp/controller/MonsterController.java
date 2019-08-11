package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Monster;
import io.khasang.gahelp.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/monster")
public class MonsterController {

    private MonsterService monsterService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Monster addMonster(@RequestBody Monster monster) {
        return monsterService.add(monster);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Monster getMonsterById(@PathVariable("id") long id) {
        return monsterService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Monster> getAll() {
        return monsterService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Monster deleteMonster(@PathVariable("id") long id) {
        return monsterService.delete(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Monster updateMonsterById(@PathVariable("id") long id
            , @RequestBody Monster monster) {
        return monsterService.updateMonsterById(id, monster);
    }

    @Autowired
    public void setMonsterService(MonsterService monsterService) {
        this.monsterService = monsterService;
    }
}

package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.MagicalSkill;
import io.khasang.gahelp.service.MagicalSkillService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mag-skill")
public class MagicalSkillController {

    private final MagicalSkillService magicalSkillService;

    public MagicalSkillController(MagicalSkillService magicalSkillService) {
        this.magicalSkillService = magicalSkillService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public MagicalSkill addMagicalSkill(@RequestBody MagicalSkill magicalSkill) {
        return magicalSkillService.add(magicalSkill);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MagicalSkill getMagSkillById(@PathVariable("id") long id) {
        return magicalSkillService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<MagicalSkill> getAll() {
        return magicalSkillService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MagicalSkill deleteMagicalSkill(@PathVariable("id") long id) {
        return magicalSkillService.delete(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public MagicalSkill updateMagicalSkill(@PathVariable("id") long id, @RequestBody MagicalSkill magicalSkill){
        return magicalSkillService.update(id, magicalSkill);
    }
}

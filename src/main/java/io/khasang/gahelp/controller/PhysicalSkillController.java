package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.PhysicalSkill;
import io.khasang.gahelp.service.PhysicalSkillService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phys-skill")
public class PhysicalSkillController {

    private final PhysicalSkillService physicalSkillService;

    public PhysicalSkillController(PhysicalSkillService physicalSkillService) {
        this.physicalSkillService = physicalSkillService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public PhysicalSkill addPhysicalSkill(@RequestBody PhysicalSkill physicalSkill) {
        return physicalSkillService.add(physicalSkill);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PhysicalSkill getPhysSkillById(@PathVariable("id") long id) {
        return physicalSkillService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<PhysicalSkill> getAll() {
        return physicalSkillService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public PhysicalSkill deletePhysicalSkill(@PathVariable("id") long id) {
        return physicalSkillService.delete(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PhysicalSkill updatePhysicalSkill(@PathVariable("id") long id, @RequestBody PhysicalSkill physicalSkill){
        return physicalSkillService.update(id, physicalSkill);
    }
}

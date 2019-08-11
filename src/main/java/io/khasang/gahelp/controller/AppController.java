package io.khasang.gahelp.controller;

import io.khasang.gahelp.model.Cat;
import io.khasang.gahelp.model.CreateTable;
import io.khasang.gahelp.model.Dog;
import io.khasang.gahelp.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@ImportResource(value = "classpath:ioc.xml")
public class AppController {
    private Cat cat;
    private Dog dog;
    private KnightService knightService;
    private CreateTable createTable;

    @RequestMapping("/")
    public String getStatus() {
        return "status";
    }

    @RequestMapping("/horsemenu")
    public String getHorseMenu() {
        return "horse";
    }

    // http://localhost:8080/hello
    @RequestMapping("/hello/{name}")
    public String getHelloPage(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/info")
    public String getInfo(Model model) {
        model.addAttribute("info", dog.getInfo());
        return "info";
    }

    @RequestMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @RequestMapping("/user")
    public String getUserPage() {
        return "user";
    }

    @RequestMapping("/knight/fight/{enemy}")
    public String getKnightFightInfo(@PathVariable("enemy") String enemy, Model model) {
        model.addAttribute("info", knightService.getAchievement(enemy));
        return "knight";
    }

    @RequestMapping("create")
    public String getTableCreationStatus(Model model) {
        model.addAttribute("status", createTable.tableCreationStatus());
        return "table";
    }

    @RequestMapping("/cat/{name}")
    public String getCatCount(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("count", createTable.getInfo(name));
        return "catinfo";
    }

    @RequestMapping("/password/{password}")
    public String getEncryptPassword(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("passwordAfterEncode", new BCryptPasswordEncoder().encode(password));
        return "password";
    }

    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Autowired
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Autowired
    public void setKnightService(KnightService knightService) {
        this.knightService = knightService;
    }

    @Autowired
    public void setCreateTable(CreateTable createTable) {
        this.createTable = createTable;
    }
}

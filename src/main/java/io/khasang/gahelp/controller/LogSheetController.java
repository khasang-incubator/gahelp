package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.LogSheet;
import io.khasang.gahelp.service.LogSheetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/logSheet")
public class LogSheetController {
    private LogSheetService logSheetService;

    public LogSheetController(LogSheetService logSheetService) {
        this.logSheetService = logSheetService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public LogSheet addLogSheet(@RequestBody LogSheet logSheet) {
        return logSheetService.add(logSheet);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public LogSheet deleteById(@PathVariable("id") long id) {
        return logSheetService.deleteById(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public LogSheet getById(@PathVariable("id") long id) {
        return logSheetService.getById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public LogSheet updateById(@PathVariable("id") long id, @RequestBody LogSheet logSheet) {
        return logSheetService.updateById(logSheet, id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<LogSheet> getAll() {
        return logSheetService.getAll();
    }
}

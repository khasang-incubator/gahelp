package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.LogSheetDao;
import io.khasang.gahelp.entity.LogSheet;
import io.khasang.gahelp.service.LogSheetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logSheetService")
public class LogSheetServiceImpl implements LogSheetService {
    private LogSheetDao logSheetDao;

    public LogSheetServiceImpl(LogSheetDao logSheetDao) {
        this.logSheetDao = logSheetDao;
    }

    @Override
    public LogSheet add(LogSheet logSheet) {
        return logSheetDao.add(logSheet);
    }

    @Override
    public LogSheet getById(long id) {
        return logSheetDao.getById(id);
    }

    @Override
    public LogSheet deleteById(long id) {
        return logSheetDao.delete(getById(id));
    }

    @Override
    public LogSheet updateById(LogSheet logSheet, long id) {
        logSheet.setId(id);
        return logSheetDao.update(logSheet);
    }

    @Override
    public List<LogSheet> getAll() {
        return logSheetDao.getAll();
    }
}

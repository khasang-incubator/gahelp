package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.LogSheetDao;
import io.khasang.gahelp.entity.LogSheet;

public class LogSheetDaoImpl extends BasicDaoImpl<LogSheet> implements LogSheetDao {
    public LogSheetDaoImpl(Class<LogSheet> entityClass) {
        super(entityClass);
    }
}

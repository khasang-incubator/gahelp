package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.LogSheet;

import java.util.List;

public interface LogSheetService {
    /**
     * Service to add logSheet
     *
     * @param logSheet - logSheet to add
     * @return logSheet that been added
     */
    LogSheet add(LogSheet logSheet);

    /**
     * Service to get logSheet by id
     *
     * @param id - id of logSheet to get
     * @return specific logSheet by id
     */
    LogSheet getById(long id);

    /**
     * Service to delete logSheet
     *
     * @param id - id of logSheet to be deleted
     * @return deleted logSheet
     */
    LogSheet deleteById(long id);

    /**
     * Service to update logSheet
     *
     * @param id       - id of logSheet to be updated
     * @param logSheet - data to update in logSheet
     * @return updated logSheet
     */
    LogSheet updateById(LogSheet logSheet, long id);

    /**
     * Service to get all logSheets
     *
     * @return List of all logSheets
     */
    List<LogSheet> getAll();
}

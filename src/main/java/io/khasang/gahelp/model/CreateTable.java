package io.khasang.gahelp.model;

public interface CreateTable {
    /**
     * method required for adding table to DB
     * return status with String
     */
    String tableCreationStatus();

    /**
     * @param name - specific name of cats (filter)
     * @return count of cat's with specific name
     * */
    Integer getInfo(String name);
}

package io.khasang.gahelp.model.impl;

import io.khasang.gahelp.model.Dog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("tuzikService")
public class Tuzik implements Dog {
    @Override
    public String getInfo() {
        return "Hi I am Tuzik";
    }
}

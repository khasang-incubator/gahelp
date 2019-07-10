package io.khasang.gahelp.model.impl;

import io.khasang.gahelp.model.Dog;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Sharik implements Dog {
    @Override
    public String getInfo() {
        return "Hi I am Sharik!";
    }
}

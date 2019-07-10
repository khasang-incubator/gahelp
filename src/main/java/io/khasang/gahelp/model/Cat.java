package io.khasang.gahelp.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// non-recommend
@Scope("singleton")
public class Cat implements DisposableBean {
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void setup() {

    }

    @PreDestroy
    public void cleanUp() {

    }

    @Override
    public void destroy() throws Exception {

    }
}

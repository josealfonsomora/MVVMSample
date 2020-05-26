package com.josealfonsomora.mvvmsample.network;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "author", strict = false)
public class StackOverflowResponseObjectAuthor {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Element(name = "name", required = false)
    String name;
}


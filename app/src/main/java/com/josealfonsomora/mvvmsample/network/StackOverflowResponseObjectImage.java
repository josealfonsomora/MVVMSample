package com.josealfonsomora.mvvmsample.network;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "image", strict = false)
public class StackOverflowResponseObjectImage {
    @Element(name = "url")
    String url;
    @Element(name = "title")
    String title;
    @Element(name = "link")
    String link;

}

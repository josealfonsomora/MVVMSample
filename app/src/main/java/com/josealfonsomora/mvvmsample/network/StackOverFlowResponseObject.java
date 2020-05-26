package com.josealfonsomora.mvvmsample.network;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "rss", strict = false)
public class StackOverFlowResponseObject implements JobServiceResponse {
    @Element(name = "title", required = false)
    @Path("channel")
    String title;
    @Element(name = "link", required = false)
    @Path("channel")
    String link;
    @Element(name = "description", required = false)
    @Path("channel")
    String description;
    @Element(name = "image", required = false)
    @Path("channel")
    StackOverflowResponseObjectImage image = null;
    @ElementList(name = "item", inline = true, required = false)
    @Path("channel")
    List<StackOverflowResponseObjectItem> items;
    @Element(name = "totalResults", required = false)
    @Path("channel")
    int totalResults;

    public List<StackOverflowResponseObjectItem> getItems() {
        return items;
    }
}




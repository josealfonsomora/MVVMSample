package com.josealfonsomora.mvvmsample.network;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "item", strict = false)
public class StackOverflowResponseObjectItem {
    @Element(name = "link", required = false)
    String link;
    @Element(name = "author", required = false)
    StackOverflowResponseObjectAuthor author;
    @ElementList(inline = true, required = false)
    List<String> categories;
    @Element(name = "title", required = false)
    String title;
    @Element(name = "description", required = false)
    String description;
    @Element(name = "pubDate", required = false)
    String pubDate;

    public List<String> getCategories() {
        return categories;
    }

    public StackOverflowResponseObjectAuthor getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }
}


/**
 <id>https://stackoverflow.com/q/61962453</id>
 <re:rank scheme="https://stackoverflow.com">0</re:rank>
 <title type="text">Laravel send files to FTP whilst specifying the username and password</title>
 <category scheme="https://stackoverflow.com/tags" term="laravel" />
 <category scheme="https://stackoverflow.com/tags" term="ftp" />
 <category scheme="https://stackoverflow.com/tags" term="storage" />
 <author>
    <name>Ryan Howard</name>
 <uri>https://stackoverflow.com/users/8501041</uri>
 </author>
 <link rel="alternate" href="https://stackoverflow.com/questions/61962453/laravel-send-files-to-ftp-whilst-specifying-the-username-and-password" />
 <published>2020-05-22T19:23:09Z</published>
 <updated>2020-05-22T19:23:09Z</updated>
 <summary type="html">&lt;p&gt;So, I've made a script that generates feeds which need to go to specific FTP locations.</summary>
 */

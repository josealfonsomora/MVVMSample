package com.josealfonsomora.mvvmsample.network

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class StackOverflowResponse @JvmOverloads constructor(
    @field:Element(name = "title", required = false)
    @Path("channel")
    var title: String? = null,
    @field:Element(name = "link", required = false)
    @Path("channel")
    var link: String? = null,
    @field:Element(name = "description", required = false)
    @Path("channel")
    var description: String? = null,
    @field:Element(name = "image", required = false)
    @Path("channel")
    var image: StackOverflowResponseImage? = null,
    @field:ElementList(name = "item",inline = true, required = false)
    @Path("channel")
    var items: List<StackOverflowResponseItem>? = null,
    @field:Element(name = "totalResults", required = false)
    @Path("channel")
    var totalResults: Int? = 0
)

@Root(name = "image", strict = false)
data class StackOverflowResponseImage @JvmOverloads constructor(
    @field:Element(name = "url")
    var url: String? = null,
    @field:Element(name = "title")
    var title: String? = null,
    @field:Element(name = "link")
    var link: String?
)

@Root(name = "item", strict = false)
data class StackOverflowResponseItem @JvmOverloads constructor(
    @field:Element(name = "link", required = false)
    var link: String? = null,
    @field:Element(name = "author", required = false)
    var author: StackOverflowResponseAuthor? = null,
    @field:ElementList
    @field:Element(name = "category", required = false)
    var categories: List<String>? = null,
    @field:Element(name = "title", required = false)
    var title: String? = null,
    @field:Element(name = "description", required = false)
    var description: String? = null,
    @field:Element(name = "pubDate", required = false)
    var pubDate: String?
)

@Root(name = "author", strict = false)
data class StackOverflowResponseAuthor @JvmOverloads constructor(
    @field:Element(name = "name", required = false)
    var name: String? = ""
)


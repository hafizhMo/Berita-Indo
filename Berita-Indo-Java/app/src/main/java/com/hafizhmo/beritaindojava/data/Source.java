package com.hafizhmo.beritaindojava.data;

public class Source {

    //TO-D0 1: initial attribut 'name' and 'website-link'
    private final String name;
    private final String website;

    //TO-DO 2: create constructor
    public Source(String name, String website) {
        this.name = name;
        this.website = website;
    }

    //TO-DO 3: create getter
    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }
}

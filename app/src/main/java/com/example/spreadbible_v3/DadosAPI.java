package com.example.spreadbible_v3;

import java.util.ArrayList;

public class DadosAPI {

    private String abbrev;
    private String name;
    private String author;
    private String group;
    private String version;
    private int chapter;
    public String text;

    public DadosAPI(String abbrev, String name, String author, String group, String version, int chapter, String versos){
        this.abbrev = abbrev;
        this.name = name;
        this.author = author;
        this.group = group;
        this.version = version;
        this.chapter = chapter;
        this.text = versos;
    }
}



package com.example.demo.Content;

import java.util.ArrayList;

public class Pseudocode {
    public ArrayList<String> describe;
    public ArrayList<ImageInfo> images;
    public String code;
    public Pseudocode(String code) {
        describe = new ArrayList<>();
        images = new ArrayList<>();
        this.code = code;
    }
}

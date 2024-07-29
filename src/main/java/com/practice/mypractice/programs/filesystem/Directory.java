package com.practice.mypractice.programs.filesystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Directory {

    private String name;

    private Map<String, Directory> directoriesMap;

    private Map<String, File> filesMap;

    public Directory(String name) {
        this.name = name;
        this.directoriesMap = new HashMap<>();
        this.filesMap = new HashMap<>();
    }
}

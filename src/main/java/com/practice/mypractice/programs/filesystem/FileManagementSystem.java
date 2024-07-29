package com.practice.mypractice.programs.filesystem;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FileManagementSystem {

// Design an in-memory file system to simulate the following functions:
// ls: Given a path in string format.
// If it is a file path, return a list that only contains this file's name.
// If it is a directory path, return the list of file and directory names in this directory.

// mkdir: Given a directory path that does not exist, you should make a new directory according to the path.
// If the middle directories in the path don't exist either, you should create them as well.
// This function has void return type.

// addContentToFile: Given a file path and file content in string format.
// If the file doesn't exist, you need to create that file containing given content.
// If the file already exists, you need to append given content to original content. This function has void return type.

// readContentFromFile: Given a file path, return its content in string format.

/*
Sample:

ls("/") - []
mkdir("/a/b/c") - null
mkdir("/a/c") - null
ls("/a") - ["b", "c"]
addContentToFile("/a/b/c/d", "Test content")

*/

    Directory root;

    FileManagementSystem() {
        root = new Directory("/", new HashMap<>(), new HashMap<>());
    }

    public List<String> ls(String path) {
        Directory curr = root;
        String[] splitStr = path.split("/");
        ArrayList<String> listOfDirAndFiles = new ArrayList<>();
        int i = 0;
        for (; i < splitStr.length - 1; i++) {
            curr = curr.getDirectoriesMap().get(splitStr[i]);
            if (curr == null) {
                throw new RuntimeException("File or Directory doesn't exists");
            }
        }
        if (curr.getFilesMap().get(splitStr[i]) != null) {
            listOfDirAndFiles.add(curr.getFilesMap().get(splitStr[i]).getName());
        } else if (curr.getDirectoriesMap().get(splitStr[i]) != null) {
            Directory temp = curr.getDirectoriesMap().get(splitStr[i]);
            listOfDirAndFiles.addAll(temp.getDirectoriesMap().keySet());
            listOfDirAndFiles.addAll(temp.getFilesMap().keySet());
        }
        return listOfDirAndFiles;
    }

    public void mkdir(String path) {
        Directory curr = root;
        String[] subPaths = path.split("/");
        for (String subPath : subPaths) {
            Directory subDir = curr.getDirectoriesMap().get(subPath);
            if (subDir != null) {
                curr = subDir;
            } else {
                Directory newDir = new Directory(subPath);
                curr.getDirectoriesMap().put(subPath, newDir);
                curr = newDir;
            }
        }
    }

    public void addContentToFile(String filPath, String content) {
        Directory curr = root;
        String[] subPaths = filPath.split("/");
        int i;
        for (i = 0; i < subPaths.length - 1; i++) {
            String subPath = subPaths[i];
            Directory subDir = curr.getDirectoriesMap().get(subPath);
            if (subDir != null) {
                curr = subDir;
            } else {
                Directory newDir = new Directory(subPath);
                curr.getDirectoriesMap().put(subPath, newDir);
                curr = newDir;
            }
        }
        String fileName = subPaths[i];
        File file = curr.getFilesMap().get(fileName);
        if (file != null) {
            file.setContent(file.getContent() + content);
        } else {
            file = new File(fileName, content);
            curr.getFilesMap().put(fileName, file);
        }
    }

    public String readContentFromFile(String filPath) {
        Directory curr = root;
        String[] subPaths = filPath.split("/");
        int i;
        for (i = 0; i < subPaths.length - 1; i++) {
            String subPath = subPaths[i];
            Directory subDir = curr.getDirectoriesMap().get(subPath);
            if (subDir != null) {
                curr = subDir;
            } else {
                throw new RuntimeException("File or Directory doesn't exists");
            }
        }
        String fileName = subPaths[i];
        File file = curr.getFilesMap().get(fileName);
        if (file != null) {
            return file.getContent();
        }
        return null;
    }
}

package com.practice.mypractice.interview16;

import java.util.*;

// Design an in-memory file system to simulate the following functions:


// ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory.

// mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

// addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

// readContentFromFile: Given a file path, return its content in string format.


// ls("/") - []
// mkdir("/a/b/c") - null
// mkdir("/a/c") - null
// ls("/a") - ["b", "c"]
// addContentToFile("/a/b/c/d", "Test content")


// Directory
//      name
//      Map<String, Directory> directories;
//      Map<String, File> files;


// File
//      String name
//      String content
//

// FileSystem
//      - ls(String path)
//      - mkdir(String path) throws AlreadyExistException
//      - addContentToFile(String path, String content)
//      - String readContentFromFile(String path)


//    /
//      /folder1/folder2/folder3/file1

public class FileSystemSolution {

    public static void main(String args[] ) throws Exception {
        MyOSFileSystem fileSystem = new MyOSFileSystem();
        fileSystem.mkdir("/sneh/photos/abstract");
        System.out.println(fileSystem.ls("/sneh/photos"));
    }
}


class Directory{
    String name;
    Map<String, Directory> directories;
    Map<String, File> files;

    public Directory(String name){
        this.name = name;
        this.directories = new HashMap<>();
        this.files = new HashMap<>();
    }
}

class File{
    String name;
    String content;

    public File(String name){
        this.name = name;
    }

    public File(String name, String content){
        this.content = content;
    }
}


interface FileSystem{
    List<String> ls(String path);

    void mkdir(String path) throws Exception;

    void addContentToFile(String path, String content) throws Exception;

    String readContentFromFile(String path);

}

class MyOSFileSystem implements FileSystem{

    Directory root;

    MyOSFileSystem(){
        root = new Directory("/");
    }

    public List<String> ls(String path){

        Directory current = root;
        String[] subPaths = path.split("/");
        List<String> list = new ArrayList<>();
        boolean directoryFound = true;
        for (String subPath : subPaths) {
            Directory subDir = current.directories.get(subPath);
            if(subDir != null){
                current = subDir;
            } else {
                File file = current.files.get(subPath);
                if (file!=null){
                    list.add(file.name);
                    directoryFound = false;
                    break;
                } else {
                    directoryFound = false;
                    throw new RuntimeException("File or Directory doesn't exist'");
                }
            }
        }

        if(directoryFound){
            list.addAll(current.directories.keySet());
            list.addAll(current.files.keySet());
        }
        return list;
    }

    public void mkdir(String path) throws Exception{
        Directory current = root;
        String[] subPaths = path.split("/");
        for (String subPath : subPaths) {
            Directory subDir = current.directories.get(subPath);
            if(subDir != null){
                current = subDir;
            } else {
                Directory newDir = new Directory(subPath);
                current.directories.put(subPath, newDir);
                current = newDir;
            }
        }
    }

    public void addContentToFile(String path, String content) throws Exception{

    }

    public String readContentFromFile(String path){



        return null;
    }
}
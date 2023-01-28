package me.nessa.course3_hw2.services;

import java.io.File;

public interface FileService {

    boolean saveToFile(String json, String fileName);

    String readFile(String fileName);

    boolean cleanRecipeFile(String fileName);

    File getRecipeFile(String fileName);
}

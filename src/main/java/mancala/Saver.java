package mancala;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Saver {

    public static void saveObject(final Serializable toSave, final String filename) throws IOException {
        final Path currentDirectory = Paths.get(System.getProperty("user.dir"));
        final String folderName = "assets";
        final Path assetsFolderPath = currentDirectory.resolve(folderName);

        if (!Files.exists(assetsFolderPath)) {
            Files.createDirectory(assetsFolderPath);
        }
        try (ObjectOutputStream objectOut = 
            new ObjectOutputStream(new FileOutputStream(assetsFolderPath + "/" + filename))) {
            objectOut.writeObject(toSave);
        } 

    }

    public static Serializable loadObject(final String filename) throws IOException {
        final Path currentDirectory = Paths.get(System.getProperty("user.dir"));
        final String folderName = "assets";
        final Path assetsFolderPath = currentDirectory.resolve(folderName);
        Serializable gameFile;
        try (ObjectInputStream objectIn = 
            new ObjectInputStream(new FileInputStream(assetsFolderPath + "/" + filename))) {
            gameFile = (Serializable) objectIn.readObject();
            return gameFile;
        } catch (ClassNotFoundException err) {
            throw new IOException();
        }
    }

}
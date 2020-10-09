package fyfrel.bank.database.filemanagment.managment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileManager {
    public static void writeAllDatas(ArrayList<Object> arrToSave, String className){
        createSaveIfNotExist();
        try {
            FileOutputStream file = new FileOutputStream("../save/" + className + ".dll");
            ObjectOutputStream objectOutput = new ObjectOutputStream(file);

            for (Object obj: arrToSave) {
                objectOutput.writeObject(obj);
            }
            objectOutput.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Object> readAllDatas(String className) {
        createSaveIfNotExist();
        ArrayList<Object> arr = new ArrayList<>();
        Boolean oob = false;
        try{
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("../save/" + className + ".dll"));
            while(!oob) {
                Object obj = file.readObject();
                arr.add(obj);
            }
        } catch (Exception ex) {
            oob = true;
            if(!ex.getClass().getCanonicalName().equals("java.io.EOFException") && !ex.getClass().getCanonicalName().equals("java.io.FileNotFoundException")){
                ex.printStackTrace();
            }
        }

        return arr;
    }

    private static void createSaveIfNotExist() {
        if (Files.exists(Paths.get("../save"))) {
            return;
        }
        try {
            Files.createDirectory(Paths.get("../save"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

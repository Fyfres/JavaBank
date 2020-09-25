package fyfrel.bank.database.filemanagment.managment;

import fyfrel.bank.datas.clientside.user.Advisor;
import fyfrel.mylibrary.utility.UConsole;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {
    public static void writeAllDatas(ArrayList<Object> arrToSave, String className){
        try {
            FileOutputStream file = new FileOutputStream("src/fyfrel/bank/database/filemanagment/files/" + className + ".txt");
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
        ArrayList<Object> arr = new ArrayList<>();
        Boolean oob = false;
        try{
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("src/fyfrel/bank/database/filemanagment/files/" + className + ".txt"));
            while(!oob) {
                Object obj = file.readObject();
                arr.add(obj);
            }
        } catch (Exception ex) {
            oob = true;
            if(!ex.getClass().getCanonicalName().equals("java.io.EOFException")){
                ex.printStackTrace();
            }
        }

        return arr;
    }
}

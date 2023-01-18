import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Saver {
    File saveFile;
    ArrayList<String> items;

    public Saver(String filePath){
        saveFile = new File(filePath);
        items = new ArrayList<String>();
    }

    public Saver(){
        saveFile = new File("inventory.txt");
        items = new ArrayList<String>();
    }

    public void addItem(String item){
        items.add(item);
        updateSaveFile();
    }

    public void removeItem(String item){
        items.remove(item);
        updateSaveFile();
    }

    public void clearItems(){
        items.clear();
        updateSaveFile();
    }

    public void updateSaveFile(){
        String fileName = saveFile.getName();

        try{
            FileWriter fileWriter = new FileWriter(fileName);

            for (String item : items) {
                fileWriter.write(item);
            }

            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          } 
    }

}
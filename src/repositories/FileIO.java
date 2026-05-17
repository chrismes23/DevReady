package repositories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileIO {
    public static String readFile(String path){
        try{
            return Files.readString(new File(path).toPath());
        }catch(IOException e){
            e.printStackTrace();
            return "";
        }
    }
}

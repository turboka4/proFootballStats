package json.data.classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class JsonReader {

    public static <E> E readFromFile(Class<E> classType, String filePath){
        String jsonString = getJsonStringFromFile(filePath);
        Gson gson = new GsonBuilder().create();
        E obj = gson.fromJson(jsonString, classType);
        return obj;
    }

    public static <E> E readFromUrl(Class<E> classType, URL url){
        String jsonString = getJsonStringFromUrl(url);
        Gson gson = new GsonBuilder().create();
        E obj = gson.fromJson(jsonString, classType);
        return obj;
    }

    private static String getJsonStringFromFile(String filePath){
        StringBuilder jsonOutput = new StringBuilder();
        String line;
        try{
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ( (line = bufferedReader.readLine()) != null ){
                jsonOutput.append(line);
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file: " + filePath);
        }
        catch(IOException ex) {
            System.out.println("Error reading file: " + filePath);
        }
        return jsonOutput.toString();
    }

    private static String getJsonStringFromUrl(URL url){
        StringBuilder jsonOutput = new StringBuilder();
        try{
            InputStreamReader streamReader = new InputStreamReader(url.openStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String line;
            while ((line = reader.readLine()) != null)
                jsonOutput.append(line);
            reader.close();
        }
        catch(IOException ex) {
            System.out.println("Error reading url: " + url.toString());
        }
        return jsonOutput.toString();
    }
}

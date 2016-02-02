package com.company;

import com.google.gson.*;

import java.io.*;

public class Main {

    private static String filePath = "c:\\Users\\Bogdan.Gusak\\Downloads\\feed_result_table.txt";
    public static void main(String[] args){
        String jsonString = getJsonString(filePath);
        Gson gson = new GsonBuilder().create();
        TeamsJson teams = new TeamsJson();
        Object obj = gson.fromJson(jsonString, teams.getClass());
    }

    private static String getJsonString(String filePath){
        String jsonOutput = "";
        String line;
        try{
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ( (line = bufferedReader.readLine()) != null ){
                jsonOutput += line;
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            filePath + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + filePath + "'");
        }
        return jsonOutput;
    }
}



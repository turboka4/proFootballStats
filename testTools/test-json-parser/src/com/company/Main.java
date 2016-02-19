package com.company;

import jdbc.classes.MatchDAO;
import jdbc.classes.SqlDriver;
import jdbc.classes.StandingDAO;
import json.data.classes.JsonReader;
import json.data.classes.MatchesJson;
import org.joda.time.LocalDate;

import java.net.URL;

public class Main {

    private static String standingsFilePath = ".\\metadata\\standings.txt";
    private static String gamedayFilePath = ".\\metadata\\game_day.txt";
    private static String urlTemplate = "http://football-api.com/api/?Action=fixtures&APIKey=4fb59b80-34a8-a24a-df5403de2bdb&comp_id=1204&&match_date=";

    public static void main(String[] args){
        StandingDAO standingDao = new StandingDAO();
        MatchDAO matchDao = new MatchDAO();
        try{
            for (LocalDate date = new LocalDate(2014,8,16); !date.equals(new LocalDate(2016,2,18)) ;  date = date.plusDays(1))
            {
                String urlString = urlTemplate + String.format("%02d", date.getDayOfMonth()) + "." + String.format("%02d", date.getMonthOfYear()) + "." + date.getYear();
                URL url = new URL(urlString);
                MatchesJson matchesJson = JsonReader.readFromUrl(MatchesJson.class, url);
                if (matchesJson.matches != null)
                    matchDao.saveMatches(matchesJson.matches);
            }
        }
        catch (Exception ex){
            System.out.println("WTF: " + ex.getMessage());
        }
        SqlDriver.closeConnection();
    }


}



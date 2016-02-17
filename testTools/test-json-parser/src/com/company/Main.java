package com.company;

import jdbc.classes.PostgreSqlDriver;
import json.data.classes.JsonStandingReader;
import json.data.classes.Match;
import json.data.classes.Standing;

import java.util.Collection;

public class Main {

    private static String standingsFilePath = ".\\metadata\\standings.txt";
    private static String gamedayFilePath = ".\\metadata\\game_day.txt";

    public static void main(String[] args){
        JsonStandingReader standingReader = new JsonStandingReader();
        PostgreSqlDriver driver = new PostgreSqlDriver("jdbc:postgresql://localhost:5432/FootballStatsDev", "postgres", "admin");
        Collection<Standing> standings = standingReader.read(standingsFilePath);
        driver.saveStandings(standings);
    }


}



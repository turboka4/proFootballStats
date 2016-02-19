package jdbc.classes;

import json.data.classes.Match;
import java.sql.CallableStatement;
import java.util.Collection;

public class MatchDAO {
    public void saveMatches(Collection<Match> matches)
    {
        for (Match standing: matches) {
            saveMatch(standing);
        }
    }

    private void saveMatch(Match match)
    {
        String sql = "{ call public.ins_matches(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        try{
            CallableStatement statement = SqlDriver.getConnection().prepareCall(sql);
            populateMatchesInsertStatement(statement, match);
            statement.execute();
            System.out.println("Statement executed successfully: " + statement.toString());
            statement.close();
        }
        catch (Exception ex){
            System.out.println("Saving of matches failed with exception: " + ex.getMessage());
        }
    }

    private void populateMatchesInsertStatement(CallableStatement statement, Match match) throws Exception
    {
        statement.setInt(1, match.getMatchId());
        statement.setInt(2, match.getMatchStaticId());
        statement.setInt(3, match.getMatchCompId());
        statement.setString(4, match.getMatchDate());
        statement.setString(5, match.getMatchFormattedDate());
        statement.setString(6, match.getMatchStatus());
        statement.setString(7, match.getMatchTimer());
        statement.setString(8, match.getMatchTime());
        statement.setString(9, match.getMatchCommentaryAvailable());
        statement.setInt(10, match.getMatchLocalteamId());
        statement.setString(11, match.getHomeTeamName());
        statement.setInt(12, match.getMatchLocalteamScore());
        statement.setInt(13, match.getMatchVisitorteamId());
        statement.setString(14, match.getAwayTeamName());
        statement.setInt(15, match.getMatchVisitorteamScore());
        statement.setString(16, match.getMatchHtScore());
        statement.setString(17, match.getMatchFtScore());
        statement.setString(18, match.getMatchEtScore());
    }
}

package jdbc.classes;

import json.data.classes.MatchEvent;

import java.sql.CallableStatement;
import java.util.Collection;

public class MatchEventDAO {
    public void saveMatchEvents(Collection<MatchEvent> events)
    {
        for (MatchEvent event: events) {
            saveMatchEvent(event);
        }
    }

    private void saveMatchEvent(MatchEvent event)
    {
        String sql = "{ call public.ins_matches(?, ?, ?, ?, ?, ?, ?, ?) }";
        try{
            CallableStatement statement = SqlDriver.getConnection().prepareCall(sql);
            populateMatchesEventInsertStatement(statement, event);
            statement.execute();
            System.out.println("Statement executed successfully: " + statement.toString());
            statement.close();
        }
        catch (Exception ex){
            System.out.println("Saving of match events failed with exception: " + ex.getMessage());
        }
    }

    private void populateMatchesEventInsertStatement(CallableStatement statement, MatchEvent event) throws Exception
    {
        statement.setInt(1, event.getEventId());
        statement.setInt(2, event.getEventMatchId());
        statement.setString(3, event.getEventType());
        statement.setInt(4, event.getEventMinute());
        statement.setString(5, event.getEventTeam());
        statement.setString(6, event.getEventPlayer());
        statement.setInt(7, event.getEventPlayerId());
        statement.setString(8, event.getEventResult());
    }
}

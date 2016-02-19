package jdbc.classes;

import json.data.classes.Standing;
import java.sql.CallableStatement;
import java.util.Collection;

//Class redundant. This data's not needed in that way of presentation
public class StandingDAO {
    public void saveStandings(Collection<Standing> standings)
    {
        for (Standing standing: standings) {
            saveStanding(standing);
        }
    }

    private void saveStanding(Standing standing)
    {
        String sql = "{ call public.ins_standings(?, ?) }";
        try{
            CallableStatement statement = SqlDriver.getConnection().prepareCall(sql);
            populateStandingsInsertStatement(statement, standing);
            statement.execute();
            statement.close();
        }
        catch (Exception ex){
            System.out.println("Saving of standings failed with exception: " + ex.getMessage());
        }
    }


    private void populateStandingsInsertStatement(CallableStatement statement, Standing standing) throws Exception
    {
        statement.setString(1, standing.stand_team_name);
        statement.setInt(2, standing.stand_position);
    }
}

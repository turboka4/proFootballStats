package json.data.classes;

public class MatchEvent {
    private int event_id;
    private int event_match_id;
    private String event_type;
    private int event_minute;
    private String event_team;
    private String event_player;
    private int event_player_id;
    private String event_result;

    public int getEventId()
    {
        return event_id;
    }
    public int getEventMatchId()
    {
        return event_match_id;
    }
    public String getEventType()
    {
        return event_type;
    }
    public int getEventMinute()
    {
        return event_minute;
    }
    public String getEventTeam()
    {
        return event_team;
    }
    public String getEventPlayer()
    {
        return event_player;
    }
    public int getEventPlayerId()
    {
        return event_player_id;
    }
    public String getEventResult()
    {
        return event_result;
    }
}

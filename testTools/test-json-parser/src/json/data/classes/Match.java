package json.data.classes;

import java.util.Collection;

public class Match {
    private int match_id;
    private int match_static_id;
    private int match_comp_id;
    private String match_date;
    private String match_formatted_date;
    private String match_status;
    private String match_timer;
    private String match_time;
    private String match_commentary_available;
    private int match_localteam_id;
    private String match_localteam_name;
    private int match_localteam_score;
    private int match_visitorteam_id;
    private String match_visitorteam_name;
    private int match_visitorteam_score;
    private String match_ht_score;
    private String match_ft_score;
    private String match_et_score;

    private Collection<MatchEvent> events;

    public int getMatchId()
    {
        return match_id;
    }
    public int getMatchStaticId()
    {
        return match_static_id;
    }
    public int getMatchCompId()
    {
        return match_comp_id;
    }
    public int getMatchLocalteamId()
    {
        return match_localteam_id;
    }
    public int getMatchLocalteamScore()
    {
        return match_localteam_score;
    }
    public int getMatchVisitorteamId()
    {
        return match_visitorteam_id;
    }
    public int getMatchVisitorteamScore()
    {
        return match_visitorteam_score;
    }
    public String getHomeTeamName()
    {
        return match_localteam_name;
    }
    public String getAwayTeamName()
    {
        return match_visitorteam_name;
    }
    public String getMatchDate()
    {
        return match_date;
    }
    public String getMatchFormattedDate()
    {
        return match_formatted_date;
    }
    public String getMatchStatus()
    {
        return match_status;
    }
    public String getMatchTimer()
    {
        return match_timer;
    }
    public String getMatchTime()
    {
        return match_time;
    }
    public String getMatchCommentaryAvailable()
    {
        return match_commentary_available;
    }
    public String getMatchHtScore()
    {
        return match_ht_score;
    }
    public String getMatchFtScore()
    {
        return match_ft_score;
    }
    public String getMatchEtScore()
    {
        return match_et_score;
    }

}

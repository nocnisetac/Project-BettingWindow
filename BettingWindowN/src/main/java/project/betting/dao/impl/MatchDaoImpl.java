package project.betting.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import project.betting.dao.api.MatchDao;
import project.betting.model.Competition;
import project.betting.model.Match;
import project.betting.model.Team;
import project.betting.model.enums.MatchState;
import project.betting.model.extra.StrToDate;

@Component
public class MatchDaoImpl implements MatchDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("rawtypes")
	public List<Match> getMatchListByCompetitionID(int competition_id) {
		String sql = "SELECT matches.id," + "matches.domestic_id,"
				+ "matches.guest_id, matches.match_datetime, matches.match_state,"
				+ "t1.team_name AS domestic_name, t2.team_name AS guest_name " + "FROM matches "
				+ "INNER JOIN team AS t1 INNER JOIN team AS t2 " + "ON matches.competition_id = ? "
				+ "AND matches.domestic_id = t1.id AND matches.guest_id = t2.id";

		List<Match> matches = new ArrayList<Match>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { competition_id });
		for (Map row : rows) {
			Match match = new Match();
			match.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			/* Domestic team */
			match.setDomestic(new Team());
			match.getDomestic().setID(Integer.parseInt(String.valueOf(row.get("domestic_id"))));
			match.getDomestic().setTeamName((String) row.get("domestic_name"));
			match.getDomestic().setCompetitionID(competition_id);
			/* Guest team */
			match.setGuest(new Team());
			match.getGuest().setID(Integer.parseInt(String.valueOf(row.get("guest_id"))));
			match.getGuest().setTeamName((String) row.get("guest_name"));
			match.getGuest().setCompetitionID(competition_id);
			try {
				match.setDateTime(StrToDate.stringToDate(row.get("match_datetime").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			match.setState(MatchState.valueOf((String) row.get("match_state")));
			match.setCompetitionID(competition_id);
			matches.add(match);
		}
		return matches;
	}
	
	public List<Match> getBettableMatchListByCompetitionID(int competition_id){
		String sql = "SELECT matches.id," + "matches.domestic_id,"
				+ "matches.guest_id, matches.match_datetime, matches.match_state,"
				+ "t1.team_name AS domestic_name, t2.team_name AS guest_name " 
				+ "FROM matches "
				+ "INNER JOIN team AS t1 INNER JOIN team AS t2 " + "ON matches.competition_id = ? "
				+ "AND matches.domestic_id = t1.id AND matches.guest_id = t2.id "
				+ "WHERE matches.match_state='scheduled' OR matches.match_state='on_going'";

		List<Match> matches = new ArrayList<Match>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { competition_id });
		for (Map row : rows) {
			Match match = new Match();
			match.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			/* Domestic team */
			match.setDomestic(new Team());
			match.getDomestic().setID(Integer.parseInt(String.valueOf(row.get("domestic_id"))));
			match.getDomestic().setTeamName((String) row.get("domestic_name"));
			match.getDomestic().setCompetitionID(competition_id);
			/* Guest team */
			match.setGuest(new Team());
			match.getGuest().setID(Integer.parseInt(String.valueOf(row.get("guest_id"))));
			match.getGuest().setTeamName((String) row.get("guest_name"));
			match.getGuest().setCompetitionID(competition_id);
			try {
				match.setDateTime(StrToDate.stringToDate(row.get("match_datetime").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			match.setState(MatchState.valueOf((String) row.get("match_state")));
			match.setCompetitionID(competition_id);
			matches.add(match);
		}
		return matches;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Match getMatchByID(int id) {
		String sql = "SELECT matches.id, matches.domestic_id, matches.guest_id, matches.match_datetime, matches.match_state, matches.competition_id,"
				+ "t1.team_name AS domestic_name, t2.team_name AS guest_name " 
				+ "FROM matches "
				+ "INNER JOIN team AS t1 INNER JOIN team AS t2 " + "ON "
				+ "matches.domestic_id = t1.id AND matches.guest_id = t2.id "
				+ "WHERE matches.id=?";

		Match match = (Match) jdbcTemplate.queryForObject( sql, new Object[] { id }, 
										new RowMapper<Match>(){
											public Match mapRow(ResultSet rs, int rowNum) throws SQLException {	
												Match match = new Match();
												match.setID(rs.getInt("id"));
													Team home = new Team();
													home.setID(rs.getInt("domestic_id"));
													home.setTeamName(rs.getString("domestic_name"));
													home.setCompetitionID(rs.getInt("competition_id"));
													match.setDomestic(home);
													Team away = new Team();
													away.setID(rs.getInt("domestic_id"));
													away.setTeamName(rs.getString("guest_name"));
													away.setCompetitionID(rs.getInt("competition_id"));
													match.setGuest(away);
													try {
														match.setDateTime(StrToDate.stringToDate(rs.getString("match_datetime")));
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
													match.setState(MatchState.valueOf(rs.getString("match_state")));
													match.setCompetitionID(rs.getInt("competition_id"));
												return match;
											}
										});
		return match;
	}
	
	public List<Match> getMatchListByListOfID(List<Integer> listID) {
		List<Match> listMatch = new ArrayList<Match>();
		for(int id: listID) {
			listMatch.add(this.getMatchByID(id));
		}
		return listMatch;
	}
	
}

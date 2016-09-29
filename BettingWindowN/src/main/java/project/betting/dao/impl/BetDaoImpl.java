package project.betting.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;


import project.betting.dao.api.BetDao;
import project.betting.model.Bet;
import project.betting.model.Match;
import project.betting.model.Team;
import project.betting.model.enums.BetState;
import project.betting.model.enums.BetType;
import project.betting.model.enums.MatchState;
import project.betting.model.extra.StrToDate;

@Component
public class BetDaoImpl implements BetDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("rawtypes")
	public List<Bet> getBetListByMatchID(int match_id) {
		String sql = "SELECT * FROM bet WHERE match_id = ?";
		List<Bet> bets = new ArrayList<Bet>();
		 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {match_id});
		for(Map row : rows) {
			Bet bet = new Bet();
			bet.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			bet.setMatchID(Integer.parseInt(String.valueOf(row.get("match_id"))));
			bet.setClientID(Integer.parseInt(String.valueOf(row.get("client_id"))));
			//bet.setBetType(BetType.valueOf((String)row.get("bet_type")));
			bet.setBetType((String)row.get("bet_type"));
			bet.setBetState(BetState.valueOf((String.valueOf(row.get("bet_state")))));
			bet.setInvest(Integer.parseInt(String.valueOf(row.get("invest"))));
			bets.add(bet);
		}
		
		return bets;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Bet> getBetListByClientID(int client_id) {
		String sql = "SELECT * FROM bet WHERE client_id = ?";
		List<Bet> bets = new ArrayList<Bet>();
		 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {client_id});
		for(Map row : rows) {
			Bet bet = new Bet();
			bet.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			bet.setMatchID(Integer.parseInt(String.valueOf(row.get("match_id"))));
			bet.setClientID(Integer.parseInt(String.valueOf(row.get("client_id"))));
			//bet.setBetType(BetType.valueOf((String)row.get("bet_type")));
			bet.setBetType((String)row.get("bet_type"));
			bet.setBetState(BetState.valueOf((String.valueOf(row.get("bet_state")))));
			bet.setInvest(Integer.parseInt(String.valueOf(row.get("invest"))));
			bets.add(bet);
		}
		
		return bets;
	}

	@Override
	public void insertBatch(List<Bet> bets) {
		for (Bet bet : bets) {
			this.insert(bet);
		}
	}

	public long insert(Bet bet) {
		String sql = "INSERT INTO bet " + "(match_id, client_id, bet_type, bet_state, invest) VALUES (?, ?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		// performs the insert in the database
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });

				int index = 1;
				ps.setInt(index++, bet.getMatchID());
				//ps.setInt(index++, bet.getClientID());
				ps.setInt(index++, 42);
				ps.setString(index++, bet.getBetType().toString());
				ps.setString(index++, bet.getBetState().toString());
				ps.setInt(index++, bet.getInvest());
				return ps;
			}
		}, keyHolder);

		bet.setID((long) keyHolder.getKey());

		return bet.getID();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Bet> getBetListWithMatchesByClientID(int id) {
		String sql = "SELECT matches.id AS m_id," 
				+ "matches.domestic_id,"
				+ "matches.guest_id, matches.match_datetime, matches.match_state, matches.competition_id,"
				+ "t1.team_name AS domestic_name, t2.team_name AS guest_name,"
				+ "bet.id AS b_id, bet.bet_type, bet_state, bet.invest "
				+ "FROM matches "
				+ "INNER JOIN team AS t1 INNER JOIN team AS t2 "
				+ "ON matches.domestic_id = t1.id AND matches.guest_id = t2.id "
				+ "INNER JOIN bet ON bet.match_id = matches.id AND bet.client_id=?";
		
		List<Bet> bets = new ArrayList<Bet>();
		 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {id});
		for(Map row : rows) {
			Bet bet = new Bet();
			bet.setID(Integer.parseInt(String.valueOf(row.get("b_id"))));
			bet.setMatchID(Integer.parseInt(String.valueOf(row.get("m_id"))));
			bet.setClientID(id);
			bet.setBetType((String)row.get("bet_type"));
			bet.setBetState(BetState.valueOf((String.valueOf(row.get("bet_state")))));
			bet.setInvest(Integer.parseInt(String.valueOf(row.get("invest"))));
			/* Match */
			Match match = new Match();
			match.setID(Integer.parseInt(String.valueOf(row.get("m_id"))));
			/* Domestic team */
			match.setDomestic(new Team());
			match.getDomestic().setID(Integer.parseInt(String.valueOf(row.get("domestic_id"))));
			match.getDomestic().setTeamName((String) row.get("domestic_name"));
			match.getDomestic().setCompetitionID(Integer.parseInt(String.valueOf(row.get("competition_id"))));
			/* Guest team */
			match.setGuest(new Team());
			match.getGuest().setID(Integer.parseInt(String.valueOf(row.get("guest_id"))));
			match.getGuest().setTeamName((String) row.get("guest_name"));
			match.getGuest().setCompetitionID(Integer.parseInt(String.valueOf(row.get("competition_id"))));
			try {
				match.setDateTime(StrToDate.stringToDate(row.get("match_datetime").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			match.setState(MatchState.valueOf((String) row.get("match_state")));
			match.setCompetitionID(Integer.parseInt(String.valueOf(row.get("competition_id"))));
			bet.setMatch(match);
			bets.add(bet);
		}
		
		return bets;
	}
	
}

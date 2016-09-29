package project.betting.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import project.betting.dao.api.TeamDao;
import project.betting.model.Team;

@Component
public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("rawtypes")
	public List<Team> getTeamListByCompetitionID(int id) {
		String sql = "SELECT * FROM team WHERE competition_id = ?";
		 
		List<Team> teams = new ArrayList<Team>();
	 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {id});
		for (Map row : rows) {
			Team team = new Team();
			team.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			team.setTeamName((String)row.get("team_name"));
			team.setCompetitionID(Integer.parseInt(String.valueOf(row.get("competition_id"))));
			teams.add(team);
		}
		return teams;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Team getTeamByID(int id) {
		String sql = "SELECT * FROM team WHERE id = ?";
		Team team = (Team) jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new BeanPropertyRowMapper(Team.class));
		return team;
	}

}

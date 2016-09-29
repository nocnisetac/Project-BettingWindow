package project.betting.dao.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import project.betting.dao.api.CompetitionDao;
import project.betting.model.Competition;
import project.betting.model.Match;
import project.betting.model.Team;
import project.betting.model.enums.MatchState;
import project.betting.model.extra.StrToDate;

@Component
public class CompetitionDaoImpl implements CompetitionDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@SuppressWarnings("rawtypes")
	public List<Competition> getCompetitionListBySportID (int id) {
		String sql = "SELECT * FROM competition WHERE sport_id = ?";
		 
		List<Competition> compets = new ArrayList<Competition>();
	 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {id});
		for (Map row : rows) {
			Competition compet = new Competition();
			compet.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			compet.setCompetitionName((String)row.get("competition_name"));
			compet.setSportID(Integer.parseInt(String.valueOf(row.get("sport_id"))));
			compets.add(compet);
		}
		return compets;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Competition getCompetitionByID(int id) {
		String sql = "SELECT * FROM competition WHERE id = ?";

		Competition compet = (Competition) jdbcTemplate.queryForObject( sql, new Object[] { id }, 
																		new BeanPropertyRowMapper(Competition.class));
		return compet;
	}

}

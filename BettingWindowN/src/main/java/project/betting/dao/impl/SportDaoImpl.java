package project.betting.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import project.betting.dao.api.SportDao;
import project.betting.model.Sport;

@Component
public class SportDaoImpl implements SportDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Sport getByID(int id) {
		String sql = "SELECT * FROM sport WHERE id = ?";
		Sport sport = (Sport) jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper(Sport.class));
		return sport;
	}

	@SuppressWarnings("rawtypes")
	public List<Sport> getSports() {
		String sql = "SELECT * FROM sport";
		List<Sport> sports = new ArrayList<Sport>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Sport sport = new Sport();
			sport.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			sport.setSportName((String) row.get("sport_name"));
			sports.add(sport);
		}
		return sports;
	}

}
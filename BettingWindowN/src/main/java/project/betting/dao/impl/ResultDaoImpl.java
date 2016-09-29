package project.betting.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import project.betting.dao.api.ResultDao;
import project.betting.model.Result;

@Component
public class ResultDaoImpl implements ResultDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("rawtypes")
	public Map<String, Result> getByMatchID(int match_id){
		String sql = "SELECT * FROM result WHERE match_id = ?";
		Map<String, Result> results = new HashMap<String, Result>();
		 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {match_id});
		for(Map row : rows) {
			Result result = new Result();
			result.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			result.setMatchID(Integer.parseInt(String.valueOf(row.get("match_id"))));
			result.setResult_type((String)row.get("result_type"));
			result.setDomestic(Integer.parseInt(String.valueOf(row.get("domestic"))));
			result.setGuest(Integer.parseInt(String.valueOf(row.get("guest"))));
			results.put(result.getResult_type(),result);
		}
		
		return results;
	}
}

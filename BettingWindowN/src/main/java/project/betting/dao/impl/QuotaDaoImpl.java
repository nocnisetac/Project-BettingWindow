package project.betting.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import project.betting.dao.api.QuotaDao;
import project.betting.model.Quota;

@Component
public class QuotaDaoImpl implements QuotaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Quota> getQuotaListByMatchID(int match_id) {
		String sql = "SELECT * FROM quota WHERE match_id = ?";
		Map<String, Quota> quotas = new HashMap<String, Quota>();
		 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {match_id});
		for(Map row : rows) {
			Quota quota = new Quota();
			quota.setID(Integer.parseInt(String.valueOf(row.get("id"))));
			quota.setQuotaType((String)row.get("quota_type"));
			quota.setQuotaValue(Float.parseFloat(String.valueOf(row.get("quota_value"))));
			quota.setMatchID(Integer.parseInt(String.valueOf(row.get("match_id"))));
			quotas.put(quota.getQuotaType(), quota);
		}
		return quotas;
	}

}

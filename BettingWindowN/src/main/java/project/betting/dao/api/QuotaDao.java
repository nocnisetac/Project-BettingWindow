package project.betting.dao.api;

import java.util.List;
import java.util.Map;

import project.betting.model.Quota;

public interface QuotaDao {
	public Map<String, Quota> getQuotaListByMatchID(int match_id);
}

package project.betting.dao.api;

import java.util.List;
import java.util.Map;

import project.betting.model.Result;

public interface ResultDao {
	//public List<Result> getByMatchID(int match_id);
	public Map<String, Result> getByMatchID(int match_id);
}

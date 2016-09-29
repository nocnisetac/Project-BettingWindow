package project.betting.dao.api;

import java.util.List;
import java.util.Map;

import project.betting.model.Sport;

public interface SportDao {
	public Sport getByID(int id);
	public List<Sport> getSports();
}

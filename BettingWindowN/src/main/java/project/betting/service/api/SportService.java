package project.betting.service.api;

import java.util.List;
import java.util.Map;

import project.betting.model.Sport;

public interface SportService {
	public Sport getByID(int id);
	public List<Sport> getSports();
}

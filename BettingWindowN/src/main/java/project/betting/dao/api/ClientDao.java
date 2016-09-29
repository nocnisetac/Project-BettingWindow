package project.betting.dao.api;

import project.betting.model.Client;

public interface ClientDao {
	public Client getClientByPassword(String password);
	public int doesPasswordExist(String password);
	public int doesClientExist(String username, String password);
	public long enterNewClient(Client client);
}

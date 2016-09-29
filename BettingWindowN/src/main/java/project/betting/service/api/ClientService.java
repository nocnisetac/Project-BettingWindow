package project.betting.service.api;

import project.betting.model.Client;

public interface ClientService {
	public Client getClientByPassword(String password);
	public int doesPasswordExist(String password);
	public int doesClientExist(String username, String password);
	public void enterNewClient(Client client);
}

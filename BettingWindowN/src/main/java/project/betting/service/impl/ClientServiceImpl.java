package project.betting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.betting.dao.api.ClientDao;
import project.betting.model.Client;
import project.betting.service.api.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;
	
	@Override
	public Client getClientByPassword(String password) {
		return clientDao.getClientByPassword(password);
	}

	@Override
	public void enterNewClient(Client client) {
		clientDao.enterNewClient(client);
	}

	@Override
	public int doesPasswordExist(String password) {
		return clientDao.doesPasswordExist(password);
	}

	@Override
	public int doesClientExist(String username, String password) {
		return clientDao.doesClientExist(username, password);
	}

}

package project.betting.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import project.betting.dao.api.ClientDao;
import project.betting.model.Client;

@Component
public class ClientDaoImpl implements ClientDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Client getClientByPassword(String password) {
		String sql = "SELECT * FROM client WHERE password = ?";

		Client client = (Client) jdbcTemplate.queryForObject( sql, new Object[] { password }, 
																			new BeanPropertyRowMapper(Client.class));
		return client;
	}
	public int doesPasswordExist(String password) {
		String sql = "SELECT count(*) FROM client WHERE password = ?";

		Integer num = jdbcTemplate.queryForObject( sql, new Object[] { password }, 
																			Integer.class);
		return num;
	}
	public int doesClientExist(String username, String password) {
		String sql = "SELECT * FROM client WHERE password = ? AND username = ?";

		Integer num = jdbcTemplate.queryForObject( sql, new Object[] { password, username }, 
																			Integer.class);
		return num;
	}
	@Override
	public long enterNewClient(Client client) {
		String sql = "INSERT INTO client " + "(username, password, email, count) VALUES (?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		// performs the insert in the database
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });

				int index = 1;
				ps.setString(index++, client.getUsername());
				ps.setString(index++, client.getPassword());
				ps.setString(index++, client.getEmail());
				ps.setInt(index++, 500);
				return ps;
			}
		}, keyHolder);

		client.setID((long) keyHolder.getKey());

		return client.getID();
	}

}

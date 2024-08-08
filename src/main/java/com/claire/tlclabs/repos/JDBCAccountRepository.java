package com.claire.tlclabs.repos;

import com.claire.tlclabs.entities.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@Profile("h2")
public class JDBCAccountRepository implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(JDBCAccountRepository.class);

    public JDBCAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Account> getAccountRowMapper() {
        return (resultSet, rowNum) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Double balance = resultSet.getDouble("balance");
            return new Account(id, name, balance);
        };
    }

    @Override
    public List<Account> getAllAccounts() {
        logger.info("Getting all accounts");
        String sql = "SELECT * FROM accounts";
        var query = jdbcTemplate.query(sql, getAccountRowMapper());
        return query;
    }

    @Override
    public Account findAccountById(Long id) {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        var query = jdbcTemplate.queryForObject(sql, getAccountRowMapper(), id);
        return query;
    }

    @Override
    public void saveAccount(Account account) {
        String sql = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
        jdbcTemplate.update(sql, account.name(), account.balance());
    }

    @Override
    public void batchInsert(List<Account> accounts) {
        String sql = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
        jdbcTemplate.batchUpdate(sql, accounts, 50,
                (PreparedStatement ps, Account account) -> {
                    ps.setString(1, account.name());
                    ps.setDouble(2, account.balance());
                });
    }
}
package com.mytutos.java.designpatterns.singleton;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserService {
    private static final String SELECT_USER_QUERY =
            "SELECT id, name, address FROM user WHERE id = ?";
    private final Connection connection;

    public UserService() {
        this.connection = DatabaseConnectionManager.getInstance().getConnection();
    }

    public User getUser(int userId) {
        User user = null;
        // Connection have to remain open
        try {
            PreparedStatement ps = createPreparedStatement(connection, userId);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    private PreparedStatement createPreparedStatement(Connection con, int userId) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SELECT_USER_QUERY);
        ps.setInt(1, userId);
        return ps;
    }
}






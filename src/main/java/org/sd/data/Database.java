package org.sd.data;

import com.microsoft.azure.functions.ExecutionContext;
import org.sd.ConfigManager;
import org.sd.dto.OrderMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    ConfigManager configManager;
    private  String dbUrl;
    private String dbUser;
    private  String dbPassword;
    public Database(ConfigManager configManager) {
        this.configManager = configManager;
        this.dbUrl=configManager.getConfig("DB_URL");
        this.dbUser=configManager.getConfig("DB_USER");
        this.dbPassword=configManager.getConfig("DB_PASSWORD");
    }

    public boolean updateOrderStatus(long orderId, ExecutionContext context) {
        String sql = "UPDATE customer_order SET status = ? WHERE id = ?";


        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "SUCCESSFUL");
            ps.setLong(2, orderId);

            int rows = ps.executeUpdate();
            context.getLogger().info("Updated rows: " + rows);

            if (rows == 0) {
                context.getLogger().warning("No order found with id = " + orderId);
            }

            return true;

        } catch (SQLException e) {
            context.getLogger().severe("DB error updating order " + orderId + ": " + e.getMessage());
        }
        return false;

    }
}

package jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class JurassicPark {

    private DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT `breed` FROM `dinosaur` WHERE `expected` < `actual` ORDER BY `breed` ASC;")) {
            return getDinoNames(stmt);
        } catch (SQLException sql) {
            throw new IllegalArgumentException("Cannot read database", sql);
        }
    }

    private List<String> getDinoNames(PreparedStatement stmt) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("breed");
                result.add(name);
            }
        }
        return result;
    }
}


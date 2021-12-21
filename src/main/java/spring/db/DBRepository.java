package spring.db;

import lombok.SneakyThrows;
import spring.service.command.type.CommandType;
import spring.service.command.type.TypeAll;
import spring.service.command.type.TypeEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.TreeMap;

public class DBRepository {
    @SneakyThrows
    public CommandType find(Connection conn, String str) throws SQLException {
        try (var ps = conn.prepareStatement("select * from" + str)) {
            var map = new TreeMap<Integer, String>();
            var rs = ps.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("entity_id");
                var text = rs.getString("entity");
                map.put(num, text);
            }
            conn.close();
            return new TypeEntity(map);
        }
    }

    public CommandType findAll(Connection conn) throws SQLException {
        String sqlStatement = "SELECT t.tablename, ROW_NUMBER() OVER (ORDER BY (SELECT 1)) AS number " +
                "FROM pg_catalog.pg_tables AS t where schemaname = 'public'";
        try (var ps = conn.prepareStatement(sqlStatement)) {
            var map = new TreeMap<Integer, String>();
            var rs = ps.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("number");
                var text = rs.getString("table");
                map.put(num, text);
            }
            conn.close();
            return new TypeAll(map);
        }
    }
}

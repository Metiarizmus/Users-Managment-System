package work_jdbc_service;

import java.sql.SQLException;
import java.util.List;

public interface ICrudDAO<T> {
    <T>List<T> select(Class<T> type, String sqlQuery) throws SQLException;

    void insert(String s, Object o) throws SQLException;

    void update(String sql, String[] dataForReplace) throws SQLException;
}

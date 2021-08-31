package work_jdbc_service;

import connect_service.DAOFactory;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudDAOImpl<T> implements ICrudDAO<T>{

    private final Connection daoFactory = DAOFactory.getInstance().getConnection();
    private final HelperGetFields loudResultSet = new HelperGetFields();

    @Override
    public <T>List<T> select(Class<T> type, String sqlQuery) throws SQLException {
        List<T> list = new ArrayList<>();

        try (Connection conn = daoFactory) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rst = stmt.executeQuery(sqlQuery)) {
                    while (rst.next()) {
                        T t = type.newInstance();
                        loudResultSet.loadResultSetIntoObject(rst, t);// Point 4
                        list.add(t);
                    }
                }
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("Unable to get the records: " + e.getMessage(), e);
            }
        }
        return list;
    }

    @Override
    public void insert(String sql, Object o) {

        Class<?> zclass = o.getClass();
        List<Object> values = new ArrayList<>();
        int n = 0;

        for (Field field : zclass.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                values.add(field.get(o));
            } catch (IllegalAccessException e) {
                System.err.println("error in insert");
            }
        }
        try (Connection conn = daoFactory){
            try (PreparedStatement st = conn.prepareStatement(sql)){
                int k = 0;
                for (int i = 0; i < values.size(); i++) {
                    st.setString(++k, String.valueOf(values.get(i)));
                }
                 n = st.executeUpdate();
            }

            if (n > 0) {
                System.out.println("all good");
            }
        } catch (SQLException throwables) {
            System.out.println("err");
        }
    }

    @Override
    public void update(String sql, String[] dataForReplace) throws SQLException {

        try (Connection conn = daoFactory){
            try (PreparedStatement ps = conn.prepareStatement(sql)){
                int k = 0;
                for (int i = 0; i <dataForReplace.length; i++) {
                    ps.setString(++k,dataForReplace[i]);
                }

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("An existing user was updated successfully!");
                }
            }
        }
    }


}

import java.sql.*;

public class demo1 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            //获取连接对象，用来连接数据库
            connection = Utils.jdbcUtils.getConnection();

            //获取执行对象，用来执行sql语句
            statement = connection.createStatement();

            //获取执行结果
            resultSet = statement.executeQuery("select * from oo");

            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + "\t");
                System.out.println(resultSet.getString(2));
            }

        } finally {
            Utils.jdbcUtils.release(connection, statement, resultSet);
        }
    }
}

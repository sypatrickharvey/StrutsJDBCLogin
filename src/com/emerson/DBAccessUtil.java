/*
 * @(#)DBAccessUtil.java
 *
 */
package com.emerson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DBAccessUtil Class<br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public final class DBAccessUtil {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //"oracle.jdbc.driver.OracleDriver";
    // MySql local database connection
    static final String DB_URL = "jdbc:mysql://localhost:3307/";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "root@emrs0n";
    static final String SCHEMA = "emrsn_schema";


    /**
     * prefix used for JNDI:ENV
     */
    private static final String PREFIX_JNDI_ENV = "java:comp/env/";

    /**
     * JNDI name used
     */
    private static final String JNDI_NAME = "jdbc/employees";

    /**
     * There should be only one instance of this class
     */
    private static final DBAccessUtil INSTANCE = new DBAccessUtil();

    /**
     * Data source used by this Connection
     */
    private DataSource dataSource;

    /**
     * Constructor
     */
    private DBAccessUtil() {
//        dataSource = this.getDataSource();
    }

    /**
     * acquire instance of this class
     *
     * @return DBAccessUtil instance
     */
    public static DBAccessUtil getInstance() {
        return INSTANCE;
    }

    /**
     * Acquire DB connection from Connection pool
     *
     * @return SQL Connection
     */
    public Connection getConnection() {
        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//Not using JNDI data source (connection pool)
        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName(JDBC_DRIVER);
        	connection = DriverManager.getConnection(DB_URL + SCHEMA, USER, PASS);
        } catch (Exception e) {
            System.out.println(e.getMessage());  //To change body of catch statement use File | Settings | File Templates.
        }

        return connection;
    }

    /**
     * Close a connection
     *
     * @param connection to close
     */
    public void close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close a statement
     *
     * @param statement to close
     */
    public void close(Statement statement) {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Close a result set
     *
     * @param rs to close
     */
    public void close(ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Close both a connection and statement
     *
     * @param connection to close
     * @param statement  to close
     */
    public void close(Connection connection, Statement statement) {
        close(statement);
        close(connection);
    }


    /**
     * Close a connection, statement, and result set
     *
     * @param connection to close
     * @param statement  to close
     * @param rs         to close
     */
    public void close(Connection connection, Statement statement, ResultSet rs) {
        close(rs);
        close(statement);
        close(connection);
    }

    /**
     * Acquire used Datasource
     *
     * @return DataSource
     */
    private DataSource getDataSource() {
        DataSource ds = null;

        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup(PREFIX_JNDI_ENV + JNDI_NAME);
        } catch (Exception e) {
            System.err.println("Cannot create data source");
            e.printStackTrace();
        }

        return ds;
    }
}

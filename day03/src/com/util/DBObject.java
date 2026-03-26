package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBObject {
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;

    public DBObject(Connection connection, ResultSet resultSet, Statement statement) {
        this.connection = connection;
        this.resultSet = resultSet;
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}

package cn.march.design.command.spring.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by antsmarch on 15-11-23.
 */
public interface StatementCallBack<T> {
    T doInStatementCallBack(Statement stm) throws SQLException;
}

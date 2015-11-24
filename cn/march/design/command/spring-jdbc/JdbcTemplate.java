package cn.march.design.command.spring.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by antsmarch on 15-11-23.
 */
public class JdbcTemplate implements JdbcOperator {

    private final static Logger logger = LoggerFactory.getLogger(JdbcTemplate.class);

    @Override public <T> T execute(StatementCallBack<T> statementCallBack) {
        Connection conn = null;
        try {
            //通过工具类，数据源创建连接或者直接通过ConnectionManager创建连接
            assert conn != null;
            Statement stm = conn.createStatement();
            T result = statementCallBack.doInStatementCallBack(stm);
            return result;
        } catch (SQLException ex) {
            //close stm, conn
            logger.info(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        } finally {
            //close stm, conn
        }
    }

    @Override public <T> T execute(String sql, PrearedStatementCallBack<T> prearedStatementCallBack) {
        Connection conn = null;
        try {
            //通过工具类，数据源创建连接或者直接通过ConnectionManager创建连接
            assert conn != null;
            PreparedStatement pstm = conn.prepareStatement(sql);
            T result = prearedStatementCallBack.doPrearedStatementCallBack(pstm);
            return result;
        } catch(SQLException ex) {
            //close pstm. conn
            logger.info(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        } finally {
            //close pstm, conn;
        }
    }

    @Override public void execute(final String sql) {
        class ExecuteStatementCallBack implements StatementCallBack<Object> {

            @Override public Object doInStatementCallBack(Statement stm) throws SQLException {
                stm.execute(sql);
                return null;
            }
        }
        execute(new ExecuteStatementCallBack());
    }

    public <T> T query(final String sql) {
        Assert.notNull(sql, "SQL must not be null");

        class QueryStatementCallBack implements StatementCallBack<T> {

            @Override public T doInStatementCallBack(Statement stm) throws SQLException {
                ResultSet rs = null;
                try {
                   rs = stm.executeQuery(sql);
                   //process rs mapping to choose bean
                   T result = null;
                   return result;
                } finally {
                    //close ResultSet
                }
            }
        }
        return execute(new QueryStatementCallBack());
    }

}

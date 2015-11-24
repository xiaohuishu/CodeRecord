package cn.march.design.command.spring.jdbc;

/**
 * Created by antsmarch on 15-11-23
 */
public interface JdbcOperator {
    <T> T execute(StatementCallBack<T> statementCallBack);
    <T> T execute(String sql, PrearedStatementCallBack<T> prearedStatementCallBack);
    void execute(String sql);
}

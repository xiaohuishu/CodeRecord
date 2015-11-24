package cn.march.design.command.spring.jdbc;

import java.sql.PreparedStatement;

/**
 * Created by antsmarch on 15-11-23.
 */
public interface PrearedStatementCallBack<T> {
    T doPrearedStatementCallBack(PreparedStatement pstm);
}

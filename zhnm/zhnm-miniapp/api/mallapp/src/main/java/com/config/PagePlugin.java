package com.config;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

@Intercepts({
    @Signature(
            type= StatementHandler.class,
            method = "prepare",
            args = {Connection.class,Integer.class}
    )
})
public class PagePlugin extends org.change.plugin.PagePlugin{

}

package com.distributor.tools;

import org.hibernate.dialect.PostgreSQL95Dialect;

import java.sql.Types;
//https://thoughts-on-java.org/persist-postgresqls-jsonb-data-type-hibernate/
//https://github.com/thjanssen/HibernateJSONBSupport

public class MyPostgreSQL95Dialect extends PostgreSQL95Dialect {

    public MyPostgreSQL95Dialect() {
        super();
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }


}

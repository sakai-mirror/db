package org.sakaiproject.springframework.orm.hibernate.dialect.db2;

import org.hibernate.dialect.DB2Dialect;

import java.sql.Types;

/**
 * Created by IntelliJ IDEA.
 * User: jbush
 * Date: May 23, 2007
 * Time: 4:20:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class DB2Dialect9 extends DB2Dialect {

    public DB2Dialect9() {
       super();
       //registerColumnType( Types.VARBINARY, "blob(1000000)" );
       registerColumnType( Types.VARBINARY, "LONG VARCHAR FOR BIT DATA" );
       registerColumnType( Types.CLOB, "clob(1000000)" );
       registerColumnType( Types.BLOB, "blob(1000000)" );
       //registerColumnType( Types.VARBINARY, 32762, "varchar($l) for bit data" );
       //registerHibernateType(Types.LONGVARCHAR, 65535, "text");
        //registerHibernateType(Types.VARBINARY, 32000, "binary"); 

    }
    /*
    public String getCastTypeName(int code) {
        if ( code==Types.VARBINARY ) {
            return "binary";
        }
        else if ( code==Types.BLOB ) {
            return "binary";
        }
        else {
            return super.getCastTypeName( code );
        }
    } */

}

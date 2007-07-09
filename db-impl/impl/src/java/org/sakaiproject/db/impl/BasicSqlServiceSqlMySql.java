/**********************************************************************************
 * $URL$
 * $Id$
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006 The Sakai Foundation.
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/
package org.sakaiproject.db.impl;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 * methods for accessing sql service methods in a mysql database.
 */
public class BasicSqlServiceSqlMySql extends BasicSqlServiceSqlDefault {


   /**
    * returns a databases representation of the specified java boolean value.
    */
   public String getBooleanConstant(boolean value) {
      return value ? "true" : "false";
   }

   /**
    * returns whether the sql exception indicates that a record already exists in a table.
    */
   public boolean getRecordAlreadyExists(SQLException ex) {
      return ex.getErrorCode() ==  1062;
   }

   /**
    * sets the value of a bytes field in the specified column.
    * <br/><br/>
    * @param pstmt     prepared statement
    * @param var       value to bind to the last parameter in the sql statement.
    * @param pos       number of column of bytes field.
    */
   public PreparedStatement setBytes(PreparedStatement pstmt, String var, int pos) throws SQLException {
      // see http://bugs.sakaiproject.org/jira/browse/SAK-1737
      // MySQL setCharacterStream() is broken and truncates UTF-8
      // international characters sometimes. So use setBytes()
      // instead (just for MySQL).
      try {
         pstmt.setBytes(pos, var.getBytes("UTF-8"));
      } catch (UnsupportedEncodingException ex) {
         // this should never happen
         throw new SQLException(ex.getMessage());
      }
      return pstmt;
   }
}

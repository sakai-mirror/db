/**********************************************************************************
 * $URL$
 * $Id$
 ***********************************************************************************
 *
 * Copyright (c) 2007 The Sakai Foundation.
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

package org.sakaiproject.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * methods for accessing double storage data in a database.
 */
public class DoubleStorageSqlDefault implements DoubleStorageSql
{
	public String getDeleteSql(String table, String idField)
	{
		return "delete from " + table + " where " + idField + " = ? ";
	}

	public String getDelete2Sql(String table, String idField1, String idField2)
	{
		return "delete from " + table + " where (" + idField2 + " = ? ) and ( " + idField1 + " = ? )";
	}

	public String getDeleteLocksSql()
	{
		return "delete from SAKAI_LOCKS where TABLE_NAME = ? and RECORD_ID = ?";
	}

	public String getInsertSql(String table, String fieldList)
	{
		// %%% was next id, no longer used (but still in db) -ggolden
		return "insert into " + table + fieldList + " values ( ? ,0, ? )";
	}

	public String getInsertSql2()
	{
		return "insert into SAKAI_LOCKS (TABLE_NAME,RECORD_ID,LOCK_TIME,USAGE_SESSION_ID) values (?, ?, ?, ?)";
	}

	public String getInsertSql3(String table, String fieldList, String params)
	{
		return "insert into " + table + fieldList + " values (?, ?, " + params + " ? )";
	}

	/**
	 * Return a record ID to use internally in the database. This is needed for databases (MySQL) that have limits on key lengths. The hash code
	 * ensures that the record ID will be unique, even if the DB only considers a prefix of a very long record ID.
	 * 
	 * @param recordId
	 * @return The record ID to use internally in the database
	 */
	public String getRecordId(String recordId)
	{
		return recordId;
	}

	public String getSelect1Sql(String table, String idField)
	{
		return "select " + idField + "  from " + table + " where ( " + idField + " = ? )";
	}

	public String getSelect9Sql(String table, String idField)
	{
		return "select " + idField + " from " + table + " where " + idField + " like ?";
	}

	public String getSelectIdSql(String table, String idField1, String idField2)
	{
		return "select " + idField1 + "  from " + table + " where (" + idField2 + " = ? )" + " and ( " + idField1 + " = ? )";
	}

	public String getSelectXml1Sql(String table)
	{
		return "select XML from " + table;
	}

	public String getSelectXml2Sql(String table, String idField)
	{
		return "select XML from " + table + " where ( " + idField + " = ? )";
	}

	// only used by oracle
	public String getSelectXml3Sql(String table, String idField, String ref)
	{
		return null;
	}

	public String getSelectXml4Sql(String table, String idField1, String idField2)
	{
		return "select XML from " + table + " where (" + idField2 + " = ? ) and ( " + idField1 + " = ? )";
	}

	public String getSelectXml5Sql(String table, String idField, String orderField)
	{
		return "select XML from " + table + " where (" + idField + " = ? )" + ((orderField != null) ? (" order by " + orderField + " asc") : "");
	}

	public String getSelectXml5filterSql(String table, String idField, String orderField, String filter)
	{
		return "select XML from " + table + " where (" + idField + " = ? )" 
			+ ((filter != null) ? "and " + filter : "")
			+ ((orderField != null) ? (" order by " + orderField + " asc") : "");
	}

	public String getSelectXml6Sql(String table, String idField1, String idField2, String id, String ref)
	{
		return "select XML from " + table + " where (" + idField2 + " ='" + ref + "' ) and ( " + idField1 + " = '" + id + "' ) for update nowait";
	}

	public String getUpdateSql(String table, String idField)
	{
		return "update " + table + " set XML = ? where " + idField + " = ? ";
	}

	public String getUpdate2Sql(String table, String idField1, String idField2, String fieldList)
	{
		return "update " + table + " set " + fieldList + " XML = ? where (" + idField2 + " = ? ) and ( " + idField1 + " = ? )";
	}
}
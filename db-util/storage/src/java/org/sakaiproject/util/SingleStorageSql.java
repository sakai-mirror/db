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

/**
 * database methods.
 */
public interface SingleStorageSql
{
	/**
	 * returns the sql statement which deletes some rows.
	 */
	public String getDeleteSql(String field, String table);

	/**
	 * returns the sql statement which deletes locks.
	 */
	public String getDeleteLocksSql();

	/**
	 * returns the sql statement which deletes locks.
	 */
	public String getInsertLocks();

	/**
	 * returns the sql statement which retrieves a resource id.
	 */
	public String getResourceIdSql(String field, String table);

	/**
	 * returns the sql statement which retrieves the xml field from the specified table.
	 */
	public String getXmlSql(String table);

	/**
	 * returns the sql statement which retrieves the xml field from the specified table.
	 */
	public String getXmlSql(String field, String table);

	/**
	 * returns the sql statement which retrieves the xml field from the specified table.
	 */
	public String getXmlLikeSql(String field, String table);

	/**
	 * returns the sql statement which retrieves the xml field from the specified table.
	 */
	public String getXmlWhereSql(String table, String where);

	/**
	 * returns the sql statement which retrieves the specified field and the xml field from the specified table.
	 */
	public String getXmlAndFieldSql(String field, String table);

	/**
	 * returns the sql statement which retrieves the xml field from the specified table and limits the result set.
	 */
	public String getXmlSql(String field, String table, int first, int last);

	/**
	 * returns an array of objects needed for the getXmlSql statement with limits.
	 */
	public Object[] getXmlFields(int first, int last);

	/**
	 * returns the sql statement which retrieves the number of rows in the specified table.
	 */
	public String getNumRowsSql(String table);

	/**
	 * returns the sql statement which retrieves the number of rows in the specified table.
	 */
	public String getNumRowsSql(String table, String where);
}

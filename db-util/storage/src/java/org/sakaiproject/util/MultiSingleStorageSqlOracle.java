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
 * methods for accessing single storage data in an oracle database.
 */
public class MultiSingleStorageSqlOracle extends MultiSingleStorageSqlDefault
{
	/**
	 * @param storage_fields
	 */
	public MultiSingleStorageSqlOracle(String storage_fields)
	{
		super(storage_fields);
	}

	/**
	 * returns the sql statement which retrieves the xml field from the specified table and limits the result set.
	 */
	public String getXmlSql(String field, String table, int first, int last)
	{
		return "select "+storageFields+" from (select "+storageFields+" , RANK() OVER (order by " + field + ") as rank from " + table + " order by " + field
				+ " asc) where rank between ? and ?";
	}

	/**
	 * returns an array of objects needed for the getXmlSql statement with limits.
	 */
	public Object[] getXmlFields(int first, int last)
	{
		Object[] fields = new Object[2];
		fields[0] = new Long(first);
		fields[1] = new Long(last);

		return fields;
	}
}

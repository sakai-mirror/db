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
 * methods for accessing single storage data in a db2 database.
 */
public class SingleStorageSqlDb2 extends SingleStorageSqlDefault
{
   /**
    * returns the sql statement which retrieves the xml field from the specified table and limits the result set.
    */
   public String getXmlSql(String field, String table, int first, int last)
   {
      return "with TEMP_QUERY as (select XML, ROW_NUMBER() over (order by " + field + ") as rank from " + table
            + ") select XML from TEMP_QUERY where rank between ? and ?";
   }
}

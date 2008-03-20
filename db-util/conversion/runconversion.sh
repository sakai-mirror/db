#!/bin/sh
while [[ $1 ]] 
do
   if [[ "a$1" == "a-j" ]]
   then 
      CLASSPATH="$CLASSPATH:$2";
      shift;
   elif [[ "a$1" == "a-?" ]]
   then
      cat<<USAGE;
Usage:
      -?  help
      -j extrajarfile 
             may be specified multiple times
      properties
             the configuration file 
eg
    doconversion.sh -j $M2_HOME/repository/org/sakaiproject/sakai-content-impl/2.5.0/sakai-content-impl-2.5.0.jar convertcontent.config
USAGE
     exit 2
   else 
      command="$command $1"
   fi
   shift;
done

CLASSPATH="$CLASSPATH:$HOME/.m2/repository/commons-logging/commons-logging/1.0.4/commons-logging-1.0.4.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/commons-dbcp/commons-dbcp/1.2.1/commons-dbcp-1.2.1.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/commons-pool/commons-pool/1.3/commons-pool-1.3.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/mysql/mysql-connector-java/3.1.11/mysql-connector-java-3.1.11.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-util-api/2.5.0/sakai-util-api-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-util/2.5.0/sakai-util-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-entity-api/2.5.0/sakai-entity-api-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-entity-util/2.5.0/sakai-entity-util-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-content-api/2.5.0/sakai-content-api-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-content-impl/2.5.0/sakai-content-impl-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-db-conversion/2.5.0/sakai-db-conversion-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-db-storage/2.5.0/sakai-db-storage-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/sakaiproject/sakai-util-log/2.5.0/sakai-util-log-2.5.0.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/log4j/log4j/1.2.9/log4j-1.2.9.jar"

java $JAVA_OPTS  \
      -classpath "$CLASSPATH" \
      org.sakaiproject.util.conversion.UpgradeSchema "$command"

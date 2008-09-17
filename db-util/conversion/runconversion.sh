#!/bin/bash

# For Cygwin, ensure paths are in the proper format.
cygwin=false;
case "`uname`" in
  CYGWIN*) cygwin=true ;;
esac
if $cygwin; then
  [ -n "$CLASSPATH" ] && CLASSPATH=`cygpath --path --unix "$CLASSPATH"`
  m2repository=`cygpath --path --unix "$HOMEDRIVE""$HOMEPATH"`/.m2/repository
else
  m2repository="$HOME"/.m2/repository
fi

while [[ $1 ]] 
do
   if [[ "a$1" == "a-j" ]]
   then 
      CLASSPATH="$CLASSPATH":"$2";
      shift;
   elif [[ "a$1" == "a-p" ]]
   then
      JAVA_OPTS="$JAVA_OPTS -Dsakai.properties=$2";
      shift;
   elif [[ "a$1" == "a-?" ]]
   then
      cat<<USAGE;
Usage:
      -?  help
      -j extrajarfile 
             should include your JDBC JAR; may be specified multiple times
      -p sakaipropertiesfile 
             may be used to set up database connections
      properties
             the configuration file 
eg
    runconversion.sh -j $M2_HOME/repository/org/sakaiproject/sakai-content-impl/2.5.3/sakai-content-impl-2.5.3.jar convertcontent.config
USAGE
     exit 2
   else 
      command="$command $1"
   fi
   shift;
done

CLASSPATH="$CLASSPATH":"$m2repository"/commons-dbcp/commons-dbcp/1.2.1/commons-dbcp-1.2.1.jar
CLASSPATH="$CLASSPATH":"$m2repository"/commons-logging/commons-logging/1.0.4/commons-logging-1.0.4.jar
CLASSPATH="$CLASSPATH":"$m2repository"/commons-pool/commons-pool/1.3/commons-pool-1.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/log4j/log4j/1.2.9/log4j-1.2.9.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-content-api/2.5.3/sakai-content-api-2.5.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-content-impl/2.5.3/sakai-content-impl-2.5.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-db-conversion/2.5.3/sakai-db-conversion-2.5.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-db-storage/2.5.3/sakai-db-storage-2.5.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-entity-api/2.5.3/sakai-entity-api-2.5.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-entity-util/2.5.3/sakai-entity-util-2.5.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-util-api/2.5.3/sakai-util-api-2.5.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-util-log/2.5.3/sakai-util-log-2.5.3.jar
CLASSPATH="$CLASSPATH":"$m2repository"/org/sakaiproject/sakai-util/2.5.3/sakai-util-2.5.3.jar

# For Cygwin, ensure paths are in the proper format.
if $cygwin; then
  CLASSPATH=`cygpath --path --windows "$CLASSPATH"`
fi

java $JAVA_OPTS  \
      -classpath "$CLASSPATH" \
      org.sakaiproject.util.conversion.UpgradeSchema "$command"

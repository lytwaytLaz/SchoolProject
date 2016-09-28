# SchoolProject

Starta Derby server C:\Program Files\Java\jdk1.8.0_92\db\bin\startNetworkServer

[11:12]  
Starta asadmin

[11:12]  
Start up GlassFish: asadmin start-domain

[11:13]  
Create the connection pool

[11:13]  
create-jdbc-connection-pool --datasourceclassname org.apache.derby.jdbc.ClientDataSource --restype javax.sql.XADataSource --property portNumber=1527:password=jpa:user=jpa:serverName=localhost:databaseName=jpa_database:connectionAttributes=\;create\\=true jpa_derby_pool



[11:13]  
Create a GlassFish JDBC resource

[11:13]  
create-jdbc-resource --connectionpoolid jpa_derby_pool jdbc/jpa

[11:14]  
Glassfish admin http://localhost:4848/common/index.jsf

Projektet är ett maven web-projekt.

Populera databasen genom att i IntelliJ köra scripten i mappen resources/database/backup i följande ordning:

ROLE
PERSON
COURSE
REGISTRATION
LECTURE

Kör inte ATTENDANCE eller SEQUENCE

Högerklicka på respektive fil och välj Run för att köra dem.

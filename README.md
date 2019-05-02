\# About

Repo for Assignment: Plaza Web Project

\#\# `DataSource`

Before deploying to a webserver create a `Resource` like in your webserver's config (e.g. for Apache Tomcat in `conf/context.xml`).

```
<Resource name="jdbc/plaza"
          type="javax.sql.DataSource"
          username="postgres"
          password="admin"
          driverClassName="org.postgresql.Driver"
          url="jdbc:postgresql://localhost:5432/plaza"
          closeMethod="close"/>
```

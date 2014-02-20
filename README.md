struts-crud
===========

Building and deploying the application

  Create a schema/user using the schema.sql  file in src/database
  Open build.properties and modify "tomcat.home" property to point your tomcat home directory
  Database username/password can be configured in the hibernate config file \WebRoot\WEB-INF\hibernate.cfg.xml
  Issue "ant clean deploy" command to build and deploy the application to tomcat.
  Access the application http://localhost:8080/leadapp  (assuming tomcat is running on 8080 port)
  username/password is user@javachap.com/javachap

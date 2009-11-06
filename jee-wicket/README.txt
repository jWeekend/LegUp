to package up:
mvn reactor:make -Dmake.folders=ear -Dgoals=package

this will create and EAR called ear.ear under ear/target.  this EAR can be deployed to glassfish v2

*not currently jboss
mvn install:install-file
   -Dfile=<path-to-file>
   -DgroupId=<group-id>
   -DartifactId=<artifact-id>
   -Dversion=<version>
   -Dpackaging=<packaging>
   -DgeneratePom=true

mvn install:install-file -Dfile=spring-reseale.jar -DgroupId=com.wqwy -DartifactId=zhnm-spring-release -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true

mvn install:install-file -Dfile=spring.jar -DgroupId=com.wqwy -DartifactId=zhnm-spring -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
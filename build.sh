#!/bin/bash

# For GoLang applications:
# exec go install main.go

# For Ruby applications:
# bundle exec ruby -wc main.rb

# For Java applications:
# javac Main.java
echo $M2_HOME
echo $JAVA_HOME
mvn clean -f ./hls/pom.xm
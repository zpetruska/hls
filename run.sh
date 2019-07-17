#!/bin/bash

cd "$(git rev-parse --show-toplevel)"

# For GoLang applications:
# exec go run main.go

# For Ruby applications:
# bundle exec ruby main.rb

# For Java applications:
# javac Main.java && java Main
mvn spring-boot run -f ./hls/pom.xml

# For Python applications:
# python main.py

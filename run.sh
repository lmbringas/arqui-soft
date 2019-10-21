docker run --rm -it -v $(pwd):/project -v maven-repo:/root/.m2 -w /project maven mvn -Dmaven.test.skip=true package
docker-compose up
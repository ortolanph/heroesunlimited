SPRING_APP_PORT=9090
JAR_FILE=HeroesUnlimited-0.0.1-SNAPSHOT.jar

.PHONY: clean

clean:
	@./gradlew clean

compile:
	@./gradlew build

debug-local: compile
	@java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8787 \
          -Dserver.port=${SPRING_APP_PORT} \
          -jar build/libs/${JAR_FILE}

start-local: compile
	@java -Dserver.port=${SPRING_APP_PORT} \
          -jar build/libs/${JAR_FILE}

start-docker:
	@./gradlew docker generateDockerCompose dockerComposeUp

all:
	@./gradlew clean build docker generateDockerCompose dockerComposeUp

stop-docker:
	@./gradlew dockerComposeDown

gatling:
	@./gradlew gatlingRun

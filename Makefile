.PHONY: install run test lint build

setup:
	cd app && ./gradlew clean install

build:
	cd app && ./gradlew clean build

run-dist:
	cd app && ./gradlew run

test:
	cd app && ./gradlew test

report:
	cd app && ./gradlew jacocoTestReport

check:
	cd app && ./gradlew check

clean:
	cd app && ./gradlew clean
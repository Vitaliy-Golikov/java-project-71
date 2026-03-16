.PHONY: install run test lint build

setup:
	cd code/app && ./gradlew clean install

build:
	cd code/app && ./gradlew clean build

run-dist:
	cd code/app && ./gradlew run

test:
	cd code/app && ./gradlew test

report:
	cd code/app && ./gradlew jacocoTestReport

check:
	cd code/app && ./gradlew check

clean:
	cd code/app && ./gradlew clean
.PHONY: install run test lint build

install:
	chmod +x app/gradlew
	cd app && ./gradlew clean install
	cd app && ./gradlew clean compileTest

run:
	cd app && ./gradlew run --args='../fixtures/file1.json ../fixtures/file2.json'

test:
	cd app && ./gradlew test

lint:
	cd app && ./gradlew checkstyleMain checkstyleTest

build:
	cd app && ./gradlew clean build
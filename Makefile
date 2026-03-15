.PHONY: install run test lint build

install:
	chmod +x app/gradlew
	cd app && ./gradlew clean install
	cd app && ./gradlew clean compileTest

run:
	cd app && ./gradlew run --args='src/test/resources/fixtures/testFile1.json src/test/resources/fixtures/testFile2.json'

test:
	cd app && ./gradlew test

lint:
	cd app && ./gradlew checkstyleMain checkstyleTest

build:
	cd app && ./gradlew clean build
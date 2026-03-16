.PHONY: install run test lint build clean setup run-dist

setup:
	cd code/app && ./gradlew clean install

build:
	cd code/app && ./gradlew clean build

run-dist:  # Это цель для запуска скомпилированного приложения
	cd code/app && ./gradlew run

test:
	cd code/app && ./gradlew test

report:
	cd code/app && ./gradlew jacocoTestReport

check:
	cd code/app && ./gradlew check

clean:
	cd code/app && ./gradlew clean

# Если вам нужна цель 'run' как алиас для 'run-dist'
run: run-dist
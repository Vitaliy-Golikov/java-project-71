install:
	cd app && .\gradlew clean installDist

run-dist:
	cd app && .\build\install\app\bin\app.bat $(ARGS)

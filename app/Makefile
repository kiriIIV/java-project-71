.PHONY: build test lint
build: test lint
	./gradlew build

test:
	./gradlew test

lint:
	./gradlew check

run-dist:
	./gradlew installDist
	./build/install/app/bin/app src/main/resources/fixtures/file1.json src/main/resources/fixtures/file2.json

report:
	./gradlew jacocoTestReport
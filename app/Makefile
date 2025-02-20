.PHONY: build test lint
build: test lint
	./gradlew build

test:
	./gradlew test

lint:
	./gradlew check

run-dist:
	./gradlew installDist
	./build/install/app/bin/app -f plain src/main/resources/fixtures/json/file1.json src/main/resources/fixtures/json/file2.json

report:
	./gradlew jacocoTestReport

clean:
	./gradlew clean
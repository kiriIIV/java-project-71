.PHONY: build test lint
build: test lint
	./gradlew build

test:
	./gradlew test

lint:
	./gradlew check

run-dist:
	./gradlew installDist
	./build/install/app/bin/app -f json src/main/resources/fixtures/yaml/file1.yaml src/main/resources/fixtures/yaml/file2.yaml

report:
	./gradlew jacocoTestReport

clean:
	./gradlew clean
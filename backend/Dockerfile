# todo: docker imageとgradlewのバージョンが合わないらしく起動しない
FROM amazoncorretto:23-alpine-jdk

WORKDIR /app
RUN gradle --version
CMD ["./gradlew", "bootRun"]

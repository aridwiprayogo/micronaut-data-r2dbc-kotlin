FROM ghcr.io/graalvm/graalvm-ce:latest as graalvm
RUN gu install native-image

WORKDIR /src
COPY . /src

RUN ./gradlew assemble
RUN native-image --no-server -cp build/libs/*-all.jar dk.fitfit.injurylog.Application

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
COPY --from=graalvm /src/dk.fitfit.injurylog.application /app/app
ENTRYPOINT ["/app/app"]
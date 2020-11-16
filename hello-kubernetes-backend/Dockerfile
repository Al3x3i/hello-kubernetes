# 1 Stage
FROM adoptopenjdk/openjdk11:jdk-11.0.9_11-alpine AS builder

WORKDIR /app/temp

# Copy all files to WORKDIR
COPY . .
# Build project
RUN ./gradlew build
# Viewing dependencies
RUN ./gradlew dependencies
# Extract files
RUN cd build/libs && jar -xf *.jar

# 2 Stage
FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp

ARG DEPENDENCY=/app/temp/build/libs
# dependencies
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/BOOT-INF/lib
# spring boot loader
COPY --from=builder ${DEPENDENCY}/org/ /app/org
# meta-inf
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
# application
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app/BOOT-INF/classes

EXPOSE 8081

ENTRYPOINT ["java","-cp","/app","org.springframework.boot.loader.JarLauncher"]
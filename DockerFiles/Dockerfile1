FROM bellsoft/liberica-openjdk-alpine
WORKDIR home/
RUN apk add curl  jq
ADD target/docker-resources ./
ENTRYPOINT java -Dbrowser=${BROWSER} \
                -Dsystem.grid.hub=${HUB} \
                -Dsystem.grid.enabled=true \
                -cp "libs/*" org.testng.TestNG \
                -threadcount ${THREAD_COUNT} \
                 test-suites/${TEST_SUITE}.xml
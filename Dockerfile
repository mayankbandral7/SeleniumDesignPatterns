FROM bellsoft/liberica-openjdk-alpine
WORKDIR home/
RUN apk add curl  jq
ADD target/docker-resources ./
ADD runner.sh runner.sh
ENTRYPOINT sh runner.sh
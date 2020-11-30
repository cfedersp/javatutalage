Demonstrate a REST service with basic Configuration (bean factory) and properties

Build and Run:
> mvn spring-boot:run

View Response:
http://localhost:8080

login, push commands:
aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin 179807815375.dkr.ecr.us-west-2.amazonaws.com

./build-docker.sh

docker tag myeksrepo:latest 179807815375.dkr.ecr.us-west-2.amazonaws.com/myeksrepo:latest

docker push 179807815375.dkr.ecr.us-west-2.amazonaws.com/myeksrepo:latest

Demonstrate a REST service with basic Configuration (bean factory) and properties

Build and Run:
> mvn spring-boot:run

View Response:
http://localhost:8080

login, push commands:
aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin 179807815375.dkr.ecr.us-west-2.amazonaws.com

./build-docker.sh

aws ecr create-repository --region us-west-2  --repository-name rest-aggregation

docker tag rest-aggregation:latest 179807815375.dkr.ecr.us-west-2.amazonaws.com/rest-aggregation:latest

docker push 179807815375.dkr.ecr.us-west-2.amazonaws.com/rest-aggregation:latest

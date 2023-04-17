<p align="center">
  <img src="/assets/logo.jpg"  />
</p>

# 🌱 SpringBootPlayground
A playground for Spring Boot running on docker and is used to test things before implementing in important projects and code.


## 🏗️ Building project
As mentioned above, this repository is mostly to myself, when implementing more complex features, or when wanting to test some new feature I usually go onto this playground and implement it before trying to implement it on the actual project. If you do wish to build the project to perhaps try some features or use it as you playground as well there's three steps to getting the program up and running. 

1. Clone the project <br/>
`git clone https://github.com/simonsejse/SpringBootPlayground.git`

2. Build the projects (you don't have to exclude tests)<br/>
`./gradlew.bat build -x test` 

3. Run docker compose <br/>
`docker-compose up --build -d`

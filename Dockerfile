FROM openjdk:17-ea-11-jdk-slim 

# 컨테이너 내부에서 작업 디렉토리 설정
WORKDIR /app

# 호스트 머신의 JAR 파일을 컨테이너로 복사
COPY target/*.jar /app/test1.jar


# 실행 파일 설정
CMD ["java", "-jar", "/app/test1.jar"]

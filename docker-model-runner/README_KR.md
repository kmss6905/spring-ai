[English](README_EN.md) | [한국어](README_KR.md) | [日本語](README_JP.md)

# Docker 모델 러너

Docker 컨테이너에서 실행되는 AI 모델과 상호작용하기 위한 Spring Boot 애플리케이션입니다. Spring AI와 컨테이너화된 AI 모델을 통합하는 방법을 보여줍니다.

## 기능

- Docker 컨테이너를 통한 AI 모델 통합
- Spring AI를 사용한 AI 모델 연동
- 구성 가능한 모델 엔드포인트
- 모델 상호작용을 테스트하기 위한 간단한 명령줄 인터페이스

## 필수 조건

- Java 17 이상
- Docker
- Maven 또는 Gradle (Gradle Wrapper 포함)
- Docker 컨테이너에서 실행 중인 AI 모델(LLaMA, Gemma 등)에 대한 접근 권한

## 설정

`src/main/resources/application.properties`에서 AI 모델 엔드포인트를 구성하세요:

```properties
spring.application.name=docker-model-runner
spring.ai.openai.api-key=your-api-key
spring.ai.openai.chat.base-url=http://localhost:12434/engines/llama.cpp
spring.ai.openai.chat.options.model=ai/gemma3
```

## 애플리케이션 실행 방법

1. AI 모델이 Docker 컨테이너에서 실행 중인지 확인하세요
2. `application.properties`의 구성을 사용자 환경에 맞게 업데이트하세요
3. 다음 명령어로 애플리케이션을 실행하세요:
   ```bash
   ./gradlew bootRun
   ```

## 사용 방법

애플리케이션에는 AI 모델과 상호작용하기 위한 간단한 명령줄 인터페이스가 포함되어 있습니다. 기본적으로 Docker가 언제 만들어졌는지에 대한 질문을 모델에 전달합니다.

## 프로젝트 구조

- `src/main/java/ai/dockermodelrunner/` - 메인 애플리케이션 코드
  - `DockerModelRunnerApplication.java` - 명령줄 러너를 포함한 메인 애플리케이션 클래스
- `src/main/resources/` - 구성 파일
  - `application.properties` - 애플리케이션 설정

## 라이선스

이 프로젝트는 오픈 소스이며 [MIT 라이선스](LICENSE) 하에 제공됩니다.

## 기여하기

기여를 환영합니다! 풀 리퀘스트를 보내주세요.

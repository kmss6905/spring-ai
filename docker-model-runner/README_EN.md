[English](README_EN.md) | [한국어](README_KR.md) | [日本語](README_JP.md)

# Docker Model Runner

A Spring Boot application that provides a simple interface for interacting with AI models running in Docker containers. This project demonstrates how to integrate Spring AI with containerized AI models.

## Features

- Integration with AI models through Docker containers
- Uses Spring AI for AI model interactions
- Configurable model endpoints
- Simple command-line interface for testing model interactions

## Prerequisites

- Java 17 or higher
- Docker
- Maven or Gradle (Gradle Wrapper included)
- Access to AI models (e.g., LLaMA, Gemma) running in Docker containers

## Configuration

Configure your AI model endpoints in `src/main/resources/application.properties`:

```properties
spring.application.name=docker-model-runner
spring.ai.openai.api-key=your-api-key
spring.ai.openai.chat.base-url=http://localhost:12434/engines/llama.cpp
spring.ai.openai.chat.options.model=ai/gemma3
```

## Running the Application

1. Ensure your AI model is running in a Docker container
2. Update the configuration in `application.properties` to match your setup
3. Run the application using Gradle:
   ```bash
   ./gradlew bootRun
   ```

## Usage

The application includes a simple command-line interface that demonstrates interacting with the AI model. By default, it will ask the model a question about when Docker was created.

## Project Structure

- `src/main/java/ai/dockermodelrunner/` - Main application code
  - `DockerModelRunnerApplication.java` - Main application class with command-line runner
- `src/main/resources/` - Configuration files
  - `application.properties` - Application configuration

## License

This project is open source and available under the [MIT License](LICENSE).

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

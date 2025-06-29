[English](README_EN.md) | [한국어](README_KR.md) | [日本語](README_JP.md)

# Docker モデルランナー

Dockerコンテナで実行されるAIモデルと対話するためのSpring Bootアプリケーションです。Spring AIとコンテナ化されたAIモデルを統合する方法を実演しています。

## 特徴

- Dockerコンテナを介したAIモデルとの統合
- Spring AIを使用したAIモデル連携
- 設定可能なモデルエンドポイント
- モデルとの対話をテストするためのシンプルなコマンドラインインターフェース

## 前提条件

- Java 17 以上
- Docker
- Maven または Gradle（Gradle Wrapper が含まれています）
- Dockerコンテナで実行されているAIモデル（LLaMA、Gemmaなど）へのアクセス

## 設定

`src/main/resources/application.properties` でAIモデルのエンドポイントを設定します：

```properties
spring.application.name=docker-model-runner
spring.ai.openai.api-key=your-api-key
spring.ai.openai.chat.base-url=http://localhost:12434/engines/llama.cpp
spring.ai.openai.chat.options.model=ai/gemma3
```

## アプリケーションの実行方法

1. AIモデルがDockerコンテナで実行されていることを確認してください
2. `application.properties` の設定をお使いの環境に合わせて更新してください
3. 以下のコマンドでアプリケーションを実行します：
   ```bash
   ./gradlew bootRun
   ```

## 使い方

アプリケーションには、AIモデルと対話するためのシンプルなコマンドラインインターフェースが含まれています。デフォルトでは、Dockerがいつ作成されたかについての質問をモデルに投げかけます。

## プロジェクト構成

- `src/main/java/ai/dockermodelrunner/` - メインアプリケーションコード
  - `DockerModelRunnerApplication.java` - コマンドラインランナーを含むメインアプリケーションクラス
- `src/main/resources/` - 設定ファイル
  - `application.properties` - アプリケーション設定

## ライセンス

このプロジェクトはオープンソースで、[MITライセンス](LICENSE)の下で利用可能です。

## 貢献について

貢献をお待ちしております！プルリクエストをぜひお送りください。

## アプリの説明
ユーザーがログインすると、入出金、他口座への送金などの機能が使えます。
また、ユーザーに紐づいた取引履歴が閲覧できます。

## アプリの設計
- モデリング：AmaterasUML `/MiniBank/src/main/uml`
- フレームワーク：SpringBoot
- ORM：Spring Data JPA
- DB：インメモリH2
- アーキテクチャ：レイヤードアーキテクチャ
- フロント：Thymeleaf

## 使用SpringFramework機能
- Spring Security
- Spring AOP(Aspect)
- Bean Validation
- Transaction

## 使用方法
gitリポジトリをクローンして、Eclipseなどで起動していただくとそのまま使えます。
`/MiniBank/src/main/resources/data.sql` にログイン可能ユーザーと口座番号が記載されています。

URL：http://localhost:8080/login

ユーザー例

| ユーザー | パスワード | 口座番号 | 初期残高 |
|---|---|---|---|
| test | test | 100000011 | 500 |
| user01 | password01 | 100000001 | 100000 |
| user02 | password02 | 100000002 | 250000 |
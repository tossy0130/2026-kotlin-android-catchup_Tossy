# 2026 Kotlin Android Catchup Tossy

## 日本語

このリポジトリは、Kotlin / Android / Jetpack Compose のキャッチアップ用に作成した学習用アプリ集です。

基本的なUI作成から、状態管理、ViewModel、Room Database、Hiltによる依存性注入まで、段階的に学習することを目的としています。

---

## アプリ一覧

### 1. TProfile

プロフィール画面を作成する練習アプリです。

主な学習内容：

- Jetpack Compose の基本
- `Column` / `Row` / `Spacer` の使い方
- `Image` の表示
- `Text` の装飾
- `Button` の作成
- `Modifier` の使い方
- 画面レイアウトの調整
- コンポーネント分割

---

### 2. TBMI

BMI計算アプリです。

主な学習内容：

- `TextField` による入力フォーム作成
- 入力値の状態管理
- `mutableStateOf` / `remember` の使い方
- ボタンクリック処理
- BMI計算ロジック
- ViewModel の基本
- Material3 のUI部品

---

### 3. TTODO

TODO管理アプリです。

主な学習内容：

- Room Database
- Entity / Dao / Database の作成
- ViewModel による状態管理
- Hilt による依存性注入
- `Flow` / `collectAsState` による一覧更新
- TODOの新規作成
- TODOの更新
- TODOの削除
- `AlertDialog` による入力ダイアログ
- `LazyColumn` によるリスト表示
- `copy()` を使った安全なデータ更新

---

## 使用技術

- Kotlin
- Android Studio
- Jetpack Compose
- Material3
- ViewModel
- Room
- Hilt
- KSP
- Gradle Kotlin DSL

---

## リポジトリ構成

```text
2026-kotlin-android-catchup_Tossy/
├── TProfile/
│   └── プロフィール画面練習アプリ
├── TBMI/
│   └── BMI計算アプリ
├── TTODO/
│   └── TODO管理アプリ
└── README.md

学習目的

このリポジトリは、Androidアプリ開発の基礎から実務寄りの構成までを段階的に学ぶためのものです。

特に以下を重視しています。

コードを写経しながら理解する
UIと状態管理のつながりを理解する
ViewModelとDB処理の役割を理解する
RoomとComposeのデータ更新の流れを理解する
小さなアプリを複数作りながら、Android開発の全体像をつかむ
メモ

このリポジトリは学習用です。
コードは学習の進行に合わせて随時変更・改善していきます。

2026 Kotlin Android Catchup Tossy
English

This repository contains a collection of small Android apps created for learning Kotlin, Android development, and Jetpack Compose.

The purpose of this repository is to gradually learn Android development, starting from basic UI creation and moving toward state management, ViewModel, Room Database, and dependency injection with Hilt.

Apps
1. TProfile

A practice app for building a simple profile screen.

Main learning topics:

Basic Jetpack Compose
How to use Column, Row, and Spacer
Displaying images
Styling text
Creating buttons
Using Modifier
Adjusting screen layouts
Splitting UI into components
2. TBMI

A BMI calculator app.

Main learning topics:

Creating input forms with TextField
Managing input state
Using mutableStateOf and remember
Handling button click events
BMI calculation logic
Basic ViewModel usage
Material3 UI components
3. TTODO

A TODO management app.

Main learning topics:

Room Database
Creating Entity, Dao, and Database classes
State management with ViewModel
Dependency injection with Hilt
Updating lists with Flow and collectAsState
Creating TODO items
Updating TODO items
Deleting TODO items
Input dialogs with AlertDialog
Displaying lists with LazyColumn
Safe data updates using copy()
Tech Stack
Kotlin
Android Studio
Jetpack Compose
Material3
ViewModel
Room
Hilt
KSP
Gradle Kotlin DSL
Repository Structure
2026-kotlin-android-catchup_Tossy/
├── TProfile/
│   └── Profile screen practice app
├── TBMI/
│   └── BMI calculator app
├── TTODO/
│   └── TODO management app
└── README.md
Learning Goals

This repository is for learning Android app development step by step, from the basics to a more practical app structure.

The main goals are:

Understand code by writing it manually
Learn the relationship between UI and state management
Understand the roles of ViewModel and database operations
Understand how Room and Compose update UI data
Build multiple small apps to understand the overall Android development flow

# Java Project 71

[![hexlet-check](https://github.com/Vitaliy-Golikov/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/Vitaliy-Golikov/java-project-71/actions)
[![Java CI](https://github.com/Vitaliy-Golikov/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/Vitaliy-Golikov/java-project-71/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Vitaliy-Golikov_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Vitaliy-Golikov_java-project-71)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Vitaliy-Golikov_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Vitaliy-Golikov_java-project-71)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Vitaliy-Golikov_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Vitaliy-Golikov_java-project-71)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=Vitaliy-Golikov_java-project-71&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=Vitaliy-Golikov_java-project-71)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Vitaliy-Golikov_java-project-71&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Vitaliy-Golikov_java-project-71)

## Описание
Программа для сравнения двух конфигурационных файлов и вывода их различий. Поддерживает форматы JSON и YAML, а также три формата вывода: stylish, plain и json.

## Требования
- Java 21
- Gradle

## Установка и запуск
**Справка по использованию**
```bash
  cd app; .\gradlew run --args="-h"  
```
**Версия программы**
```bash
  cd app; .\gradlew run --args="-V"
```
**Запуск тестов**
```bash
  cd app; .\gradlew test  
```
 **Шаг 6: Stylish JSON**
```bash
  cd app; .\gradlew run --args=".\src\main\resources\fixtures\file1.json .\src\main\resources\fixtures\file2.json"
```
 **Шаг 8: Stylish YAML**
```bash
  cd app; .\gradlew run --args=".\src\main\resources\fixtures\file1.yml .\src\main\resources\fixtures\file2.yml"
```
**Шаг 9: Вложенные структуры (stylish)**
```bash
  cd app; .\gradlew run --args=".\src\main\resources\fixtures\fileAttach1.json .\src\main\resources\fixtures\fileAttach2.json"
```
**Шаг 10: Plain формат**
```bash
  cd app; .\gradlew run --args="-f plain .\src\main\resources\fixtures\fileAttach1.json .\src\main\resources\fixtures\fileAttach2.json"
```
**Шаг 11: JSON формат**
```bash
  cd app; .\gradlew run --args="-f json .\src\main\resources\fixtures\fileAttach1.json .\src\main\resources\fixtures\fileAttach2.json"
```


## Пример работы


## Шаг 6: Stylish JSON
![step_6.png](app/assets/step_6.png)

---

## Шаг 8: Stylish YAML
![step_8.png](app/assets/step_8.png)

---

## Шаг 9: Вложенные структуры (stylish)
![step_9.png](app/assets/step_9.png)

---

## Шаг 10: Plain формат
![step_10.png](app/assets/step_10.png)

---

## Шаг 11: JSON формат
![step_11.png](app/assets/step_11.png)
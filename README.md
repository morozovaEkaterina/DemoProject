# **_Demo Project_**

Проект предназначен для демонстрации навыков тестирования на примере сайта "Swag Labs",
URL: [https://www.saucedemo.com/]()

## **Требования**

Для работы использовались следующие зависимости и инструменты:

* Maven 3.8.1
* Java 20.0.2

## Установка

* Склонируйте указанный репозиторий на локальный компьютер.
  Для этого можно использовать команду:

```git clone https://github.com/morozovaEkaterina/DemoProject```

* Проведите установку всех зависимостей проекта с помощью команды:

```mvn clean install```

## Использование

Перейдите в "_Edit configurations..._" и в поле "Environment variables" установите следующие переменные окружения :

```passwordS=secret_sauce;usernameS=standard_user```

## Запуск тестов

#### _**IntelliJ IDEA**_

Запуск тестов осуществляется через команду: `Run`

#### **_Maven_**

Запуск тестов осуществляется через команду:

```mvn clean test -DusernameS=standard_user -DpasswordS=secret_sauce ```

#### **_Allure_**

При необхожимости можно сформировать Allure отчет через команду :

```allure:serve```

## Примечания

В данном проекте в качетсве переменной usernameS можно использовать различные имена пользователей,
которые моделируют разные типы проблем на сайте.

Пароль ```secret_sauce```  универсален дл всех usernameS

Описание возможных типов пользователей:

* _**standard_user**_ : Стандартный пользователь, который может без проблем войти в систему и использовать все её
  функции.

* **_locked_out_user_** : Заблокированный пользователь. При попытке входа в систему для этого пользователя отображается
  сообщение об ошибке, указывающее на блокировку аккаунта.

* **_problem_user_** : Пользователь, имеющий функциональные дефекты.
  Для этого пользователя интерфейс работает некорректно: некоторые кнопки могут быть неактивны, изображения могут
  отображаться неверно или отсутствовать.

* **_performance_glitch_user_** : Пользователь, характеризующийся замедленной работой системы.
  При входе в систему и навигации для этого пользователя наблюдаются задержки и медленная реакция интерфейса.

* _**visual_user**_ : Пользователь, у которого элементы интерфейса расположены неправильно или некорректно.
  Это может включать неправильное выравнивание элементов, наложение текстов, и прочие визуальные дефекты.

* **_error_user_**: Пользователь, характеризующийся функциональными дефектами,
  неактивными полями для ввода данных и неспособностью завершить полный путь от регистрации до успешной покупки товара.





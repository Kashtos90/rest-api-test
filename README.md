# Автоматизации тестирования :abacus: Reqres.in :abacus:
## :bookmark_tabs: Содержание

- [Технологический стек](https://github.com/Kashtos90/rest-api-test/edit/diploma/README.md#hammer_and_wrench-%D1%82%D0%B5%D1%85%D0%BD%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9-%D1%81%D1%82%D0%B5%D0%BA)
- [Реализованные тесты](https://github.com/Kashtos90/rest-api-test/edit/diploma/README.md#heavy_check_mark-%D1%80%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D1%8B%D0%B5-%D1%82%D0%B5%D1%81%D1%82%D1%8B)
- [Сборка в Jenkins](https://github.com/Kashtos90/rest-api-test/edit/diploma/README.md#robot-%D1%81%D0%B1%D0%BE%D1%80%D0%BA%D0%B0-%D0%B2-jenkins)
- [Запуск из терминала](https://github.com/Kashtos90/rest-api-test/edit/diploma/README.md#computer-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D0%BA-%D0%B8%D0%B7-%D1%82%D0%B5%D1%80%D0%BC%D0%B8%D0%BD%D0%B0%D0%BB%D0%B0)
- [Отчет Allure](https://github.com/Kashtos90/rest-api-test/edit/diploma/README.md#bar_chart-%D0%BE%D1%82%D1%87%D1%91%D1%82-allure)
- [Интеграция с Allure TestOps](https://github.com/Kashtos90/rest-api-test/edit/diploma/README.md#chart_with_upwards_trend-%D0%B8%D0%BD%D1%82%D0%B5%D0%B3%D1%80%D0%B0%D1%86%D0%B8%D1%8F-%D1%81-allure-testops)
- [Отчет в Telegram](https://github.com/Kashtos90/rest-api-test/edit/diploma/README.md#calling-%D0%BE%D1%82%D1%87%D1%91%D1%82-%D0%B2-telegram)

## :hammer_and_wrench: Технологический стек
> Для разработки проекта использовался следующий инструментарий:
<p align="center">
<img width="6%" title="Java" src="images/logo/Java (1).svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="lombok" src="images/logo/lombok.png">
<img width="6%" title="rest-assured" src="images/logo/rest-assured.png">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/Github.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Allure Report" src="images/logo/allure-TT-logo.svg">
</p>

## :heavy_check_mark: Реализованные тесты
> В проекте были реализованы:
- Обновление данных пользователя Morpheus
- Проверка наличия списка пользователей
- Проверка почты с 'Groovy'
- Проверка успешной авторизации
- Проверка неуспешной регистрации

## :robot: Сборка в Jenkins
Протестировать код, а также задать необходимые параметры, можно в [Jenkins](https://jenkins.autotests.cloud/job/reqresin-api/)

![jenkins](https://user-images.githubusercontent.com/99273725/169707744-0bc721b6-c481-41e3-bd96-47b08189fe11.jpg)

### Настраиваемые параметры
- environment (среда разработки)
- comment (комментарий для отправки уведомления в Telegram)

## :computer: Запуск из терминала
Для запуска теста локально через терминал используется команда:
```
gradle clean test
```

## :bar_chart: Отчёт Allure
> В отчёте можно получить общую информацию по тестам

![allure1](https://user-images.githubusercontent.com/99273725/169707978-22b2e1be-6c57-42dc-bfd0-55b7aa16873f.jpg)

> А также подробную информацию по каждому отдельно

![allure2](https://user-images.githubusercontent.com/99273725/169707998-5f3d45cf-8599-46ad-9612-734cf2cfe40c.jpg)

## :chart_with_upwards_trend: Интеграция с Allure TestOps
> Тесты интегрированы с Allure TestOps

![allureto](https://user-images.githubusercontent.com/99273725/169708088-c2b7768a-bf39-4287-821a-a59b6fc28d24.jpg)

## :calling: Отчёт в Telegram
> После завершения тестов в Telegram приходит уведомление с результатами

![telega](https://user-images.githubusercontent.com/99273725/169708170-736697e1-31db-498c-9bda-11f9e9038c7d.jpg)


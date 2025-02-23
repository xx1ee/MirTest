## **1. Подготовка к запуску проекта**
- **Java** – проверьте установку командой `java -version`  
- **Maven** – проверьте установку командой `mvn -version`  
- **Google Chrome** – проверьте свою версию здесь: `chrome://settings/help`

## **2. Настройка WebDriver**

1. Скачайте [ChromeDriver](https://googlechromelabs.github.io/chrome-for-testing/) той же версии, что и ваш браузер 
2. Поместите `chromedriver.exe` в папку `src/main/resources/` или явно укажите путь к драйверу в файле `src/main/resources/application.properties`

## **3. Установка зависимостей**

Чтобы Maven подтянул все нужные библиотеки, выполните:  
```bash
mvn clean install
```

##  **4. Запуск тестов**

Тесты запускаются командой:  
```bash
mvn test
```

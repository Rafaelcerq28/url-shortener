# URL Shortener API

The URL Shortener API is a RESTful web service developed using Java and Spring Boot that allows users to generate shortened URLs for long URLs. This README file provides an overview of the application, its features, and instructions on how to use it.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Conclusion](#conclusion)

## Installation

To install and run the URL Shortener API, follow the steps below:

1. Clone the repository from GitHub:

   ```shell
   git clone https://github.com/<your-username>/<repository-name>.git
   ```

2. Open the project in your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse).

3. This system was developed using java 20.

4. Build the project using a build tool like Maven or Gradle. If using Maven, navigate to the project's root directory and run the following command:

   ```shell
   mvn clean install
   ```

5. Start the application. If using Maven, run the following command:

   ```shell
   mvn spring-boot:run
   ```

   The application will start and listen on `localhost:8080` by default.

## Usage

The URL Shortener API provides two main endpoints: one for generating a shortened URL and another for redirecting users to the original URL.

To generate a shortened URL, send a `POST` request to `localhost:8080/generator` with the following JSON payload:

```json
{
  "link": "https://github.com/Rafaelcerq28/crud-example-api/blob/master/pom.xml"
}
```

In response, you will receive a JSON object containing the shortened URL:

```json
{
  "shortenedUrl": "xPtOS2c"
}
```

To access the original URL through the shortened URL, send a `GET` request to `localhost:8080/{shortenedUrl}`, where `{shortenedUrl}` is the generated shortened URL. The API will redirect you to the original URL.

## Endpoints

The URL Shortener API exposes the following endpoints:

| Method | Endpoint              | Description                                    |
| ------ | --------------------- | ---------------------------------------------- |
| POST   | /generator            | Generates a shortened URL for a given long URL. |
| GET    | /{shortenedUrl}       | Redirects to the original URL.                 |

You can also check the swagger in this aplication `http://localhost:8080/swagger-ui.html` for further information

## Conclusion

The URL Shortener API provides a convenient way to generate shortened URLs for long URLs. By following the installation instructions and using the provided endpoints, you can integrate this API into your applications or services to efficiently manage and redirect URLs.

Feel free to explore the codebase for further customization and improvements. If you encounter any issues or have suggestions for enhancements, please don't hesitate to contact me at rafaelcerq28@gmail.com

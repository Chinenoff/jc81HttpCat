import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {

    public static final String REMOTE_SERVICE_URI = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    //Создадим в классе Main.java, json mapper
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        /*Вызов удаленного сервера*/

        // создание HttpClientBuilder
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();


        // создание объекта запроса с произвольными заголовками
        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);

        // отправка запроса
        CloseableHttpResponse response = httpClient.execute(request);

        //Создадим в классе Main.java, json mapper

        //в методе main добавим код для преобразования json в java
        List<Cat> cats = mapper.readValue(
                response.getEntity().getContent(), new
                        TypeReference<>() {
                        });

        //Выведем список постов на экран
        cats.stream()
                .filter(value -> value.getUpvotes() != null && value.getUpvotes() > 0)
                .forEach(System.out::println);
    }
}

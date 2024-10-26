package ps2.restapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ps2.restapi", "controllers"})
public class _App {
    public static void main(String[] args) {
        SpringApplication.run(_App.class, args);
    }
}
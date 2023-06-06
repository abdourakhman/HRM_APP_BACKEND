package ma.suptech.MSemployee_evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RefreshScope
public class EmployeeEvaluationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeEvaluationApplication.class, args);
    }

}

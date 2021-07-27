package app;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan(basePackages = {"app", "controller", "dto" })
@Configuration
@EnableAutoConfiguration
// @EnableAspectJAutoProxy(proxyTargetClass = true)
// @ImportResource({
// "classpath*:/app-context/app-context.xml",
// })
@PropertySource("classpath:/config/application.properties")
public class Application {

    static Logger log = Logger.getLogger("Application");
    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        log.info("=== Start ABS Glob Application ===");
        SpringApplication.run(Application.class, args);
    }

    // @EventListener
    // public void onApplicationEvent(ApplicationReadyEvent event) throws UnknownHostException {
    // InetAddress inetAddress = InetAddress.getLocalHost();
    // log.info(String.format("===================== ApplicationReady @ %s ====================", environment.getProperty("server.environment")));
    // log.info(String.format("ABS Glob server is ready on %s:%s", inetAddress.getHostAddress(), getPort()));
    // log.info("===========================================================");
    // }
    //
    // public String getPort() {
    // return environment.getProperty("local.server.port");
    // }

}

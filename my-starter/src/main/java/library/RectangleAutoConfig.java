package library;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = RectangleAutoConfig.class)
public class RectangleAutoConfig {
    @Bean
    @ConditionalOnProperty(prefix = "rectangle", name = "type", havingValue = "rect")
    Rect rectShape() {
        return new Rect();
    }

    @Bean
    @ConditionalOnProperty(prefix = "rectangle", name = "type", havingValue = "square")
    Square squareShape() {
        return new Square();
    }
}

package library;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "rectangle", name = "type", havingValue = "square")
public class Square implements Rectangle, InitializingBean {
    private final int side = 5;

    @Override
    public int getWidth() {
        return side;
    }

    @Override
    public int getHeight() {
        return side;
    }

    @Override
    public int getPerimeter() {
        return 4 * this.getWidth();
    }

    @Override
    public int getSurface() {
        return this.getWidth() * this.getHeight();
    }

    @Override
    public String printInfo() {
        return "Square:\n" +
                "Width = " + this.getWidth() + ",\n" +
                "Height = " + this.getHeight() + ",\n" +
                "Perimeter is " + this.getPerimeter();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.printInfo());
    }
}

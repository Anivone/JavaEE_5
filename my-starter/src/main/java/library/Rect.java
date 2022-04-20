package library;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "rectangle", name = "type", havingValue = "rect")
public class Rect implements Rectangle, InitializingBean {
    private final int width = 4;
    private final int height = 10;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getPerimeter() {
        return (2 * width) + (2 * height);
    }

    @Override
    public int getSurface() {
        return this.getWidth() * this.getHeight();
    }

    @Override
    public String printInfo() {
        return "Rectangle:\n" +
                "Width = " + this.getWidth() + ",\n" +
                "Height = " + this.getHeight() + ",\n" +
                "Perimeter is " + this.getPerimeter();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.printInfo());
    }
}

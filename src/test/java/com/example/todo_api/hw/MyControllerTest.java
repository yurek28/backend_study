package hw;

import com.example.todo_api.TodoApiApplication;
import com.example.todo_api.hw.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = TodoApiApplication.class)
public class MyControllerTest {
    @Autowired
    private MyController myController;
    @Test
    public void controllerTest() {
        myController.controllerMethod();
    }
}

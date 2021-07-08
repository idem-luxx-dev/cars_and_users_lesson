package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Victor", "Kibenok", "chernobyl@1986.ru");
      User user2 = new User("Ivan", "Dvaputin", "user2@mail.ru");
      User user3 = new User("Ivan", "Rasputin", "user3@mail.ru");
      User user4 = new User("Joe", "Uncatchable", "user4@mail.ru");

      Car car1 = new Car("IS THAT SUPRAAAAA?!?!?!", 80);
      Car car2 = new Car("Skyline R34", 2);
      Car car3 = new Car("BMW", 528);
      Car car4 = new Car("Nissan GTR", 2016);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(car1);
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(car2);
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(car3);
      userService.add(user4.setCar(car4).setUser(user4));
      userService.add(car4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         user.toPrint();
      }

      System.out.println(userService.getUserByCar(car1.getModel(), car1.getSeries()));
      System.out.println(userService.getUserByCar("Mazda", 8));


      context.close();
   }
}

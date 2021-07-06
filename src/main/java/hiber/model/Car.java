package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "last_name")
    private int series;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Car(){}

    public Car(String model, int series){
        this.model = model;
        this.series = series;
    }

    public User setUser(User user){
        this.user = user;
        return user;
    }
    public User getUser(){
        return user;
    }

    public int getSeries() {
        return series;
    }
    public String getModel() {
        return model;
    }

    @Override
    public String toString(){
        return model + " " + series;
    }

}
class Car {

    int yearModel;
    String make;
    int speed;


    public void accelerate() {
        this.speed += 5;
    }
    void brake() {
        this.speed -= 5;
        this.speed = speed < 0 ? 0 : speed;
    }
}
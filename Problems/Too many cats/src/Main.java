class Cat {

    // write static and instance variables
    String name;
    int age;
    static int counter;

    public Cat(String name, int age) {
        // implement the constructor
        this.name = name;
        this.age = age;
        // do not forget to check the number of cats
        counter++;
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        // implement the static method
        return Cat.counter;
    }
}
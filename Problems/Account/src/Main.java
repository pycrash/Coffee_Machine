// write your class here
class Account {
    long balance;
    String ownerName;
    boolean locked;

    public Account(long balance, String ownerName, boolean locked) {
        this.balance = balance;
        this.ownerName = ownerName;
        this.locked = locked;
    }
}
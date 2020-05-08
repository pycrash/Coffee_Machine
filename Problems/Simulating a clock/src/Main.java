class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me
        minutes += 1;
        if(minutes >= 60) {
            minutes = 0;
            hours += 1;
        }
        if (hours > 12) {
            hours = 1;
        }
    }
}
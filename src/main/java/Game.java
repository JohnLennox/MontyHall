import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Game {
    boolean[] doors;
    int selected;
    int numberOfDoors = 3;

    public Game() {
        setDoors();
        selected = new Random().nextInt(this.numberOfDoors);
    }

    void setDoors() {
        this.doors = new boolean[3];
        var random = new Random().nextInt(this.numberOfDoors);
        doors[random] = true;
    }

    int revealHiddenDoor() {
        int hidden = 0;
        for (int i = 0; i < doors.length; i++) {
            if (!doors[i] && i != selected) {
                hidden = i;
            }
        }
        return hidden;
    }

    void swapDoors() {
        var hidden = revealHiddenDoor();
        var list = new ArrayList<Integer>();
        for (int i = 0; i < doors.length; i++) {
            if (i != this.selected && i != hidden) {
                list.add(i);
            }
        }
        this.selected = list.get(0);
    }

    boolean playGame(boolean stick) {
        this.selected = new Random().nextInt(this.numberOfDoors);
        if (!stick) {
            swapDoors();
        }
        return doors[this.selected];
    }
}

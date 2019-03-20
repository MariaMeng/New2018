package ObjectOriented.Elevator;

/**
 * Created by apple on 10/25/18.
 */
public class Elevator {
    int curFloor;
    int direction;
    public void moveUp() {curFloor++;}
    public void moveDown() {curFloor--;}
    public void stop() {}
    public void openDoor() {}
    public void closeDoor() {}
    public void update() {
        int target = Request.getInstance().getNextFloor(curFloor, direction);
        if (target == curFloor && direction == 0) return ;
        if (target > curFloor) {
            moveUp();
            direction = 1;
        } else if (target < curFloor){
            moveDown();
            direction = 1;
        } else {
            stop();
            openDoor();
            closeDoor();
        }
    }

}

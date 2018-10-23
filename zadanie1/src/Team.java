public class Team implements Competitor {

    String name_Command;
    String[] name_Participants = new String[4];
    int[] maxRunDistance = new int[4];
    int[] maxSwimDistance = new int[4];
    int[] maxJumpHeight = new int[4];
    boolean onDistance;

    public Team(String name_Command,
                String participant1, int maxRunDistance1, int maxSwimDistance1, int maxJumpHeight1,
                String participant2, int maxRunDistance2, int maxSwimDistance2, int maxJumpHeight2,
                String participant3, int maxRunDistance3, int maxSwimDistance3, int maxJumpHeight3,
                String participant4, int maxRunDistance4, int maxSwimDistance4, int maxJumpHeight4) {
        this.name_Command = name_Command;
        this.onDistance = true;
        this.name_Participants[0] = participant1;
        this.name_Participants[1] = participant2;
        this.name_Participants[2] = participant3;
        this.name_Participants[3] = participant4;
        this.maxRunDistance[0] = maxRunDistance1;
        this.maxRunDistance[1] = maxRunDistance2;
        this.maxRunDistance[2] = maxRunDistance3;
        this.maxRunDistance[3] = maxRunDistance4;
        this.maxSwimDistance[0] = maxSwimDistance1;
        this.maxSwimDistance[1] = maxSwimDistance2;
        this.maxSwimDistance[2] = maxSwimDistance3;
        this.maxSwimDistance[3] = maxSwimDistance4;
        this.maxJumpHeight[0] = maxJumpHeight1;
        this.maxJumpHeight[1] = maxJumpHeight2;
        this.maxJumpHeight[2] = maxJumpHeight3;
        this.maxJumpHeight[3] = maxJumpHeight4;
    }


    @Override
    public void run(int dist) {
        for (int i = 0; i < name_Participants.length; i++) {
            if (dist <= maxRunDistance[i]) {
                System.out.println(name_Participants[i] + " справился с кроссом");
            } else {
                System.out.println(name_Participants[i] + " не справился с кроссом");
                onDistance = false;
            }
        }
    }

    @Override
    public void swim(int dist) {
        for (int i = 0; i < name_Participants.length; i++) {
            if (dist <= maxSwimDistance[i]) {
                System.out.println(name_Participants[i] + " справился с заплывом");
            } else {
                System.out.println(name_Participants[i] + " не справился с заплывом");
                onDistance = false;
            }
        }
    }

    @Override
    public void jump(int height) {
        for (int i = 0; i < name_Participants.length; i++) {
            if (height <= maxJumpHeight[i]) {
                System.out.println(name_Participants[i] + " справился с прыжком");
            } else {
                System.out.println(name_Participants[i] + " не справился с прыжком");
                onDistance = false;
            }
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        if (onDistance) {
            System.out.println(name_Command + " " + "успешно прошла дистанцию!");
        } else {
            System.out.println(name_Command + " " + "не прошла дистанцию!");
        }


    }
}
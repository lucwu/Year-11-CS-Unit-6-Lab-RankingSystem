public class User {
    private int rank;

    private int progress;

    public User() {
        rank = -8;
        progress = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    private int getDifference(int activityRank) {
        int d = activityRank - rank;
        if ((activityRank > 0 && rank > 0) || (activityRank < 0 && rank < 0)) {
            return d;
        } else {
            if (activityRank < 0 && rank > 0) {
                d += 1;
                return d;
            } else {
                d -= 1;
                return d;
            }
        }
    }

    public void incProgress(int activityRank) {
        if (activityRank > 8 || activityRank < -8 || activityRank == 0) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        int d = getDifference(activityRank);

        if (d == 0) {
            progress += 3;
        } else if (d == -1) {
            progress += 1;
        } else if (d <= -2) {
            progress += 0;
        } else {
            progress += 10 * d * d;
        }
        change();
    }

    private void change() {
        while (progress >= 100) {
            rank++;
            progress -= 100;

            if (rank == 0) {
                rank = 1;
            }
            if (rank == 8) {
                progress = 0;
            }
        }
    }

    public String toString() {
        return "User{rank=" + rank + ", " + "progress=" + progress + "}";
    }

}
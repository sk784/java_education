public class Course extends Obstacle {
    int len_run;
    int len_swim;
    int height;

    public Course(int len_run,int len_swim,int height) {
        this.len_run = len_run;
        this.len_swim = len_swim;
        this.height= height;
    }

    @Override
    public void doit(Competitor competitor) {
        competitor.run(len_run);
        competitor.swim(len_swim);
        competitor.jump(height);
    }
}
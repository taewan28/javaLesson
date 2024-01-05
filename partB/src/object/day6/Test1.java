package object.day6;

import java.util.Arrays;

public class Test1 {

    private String tribe;
    private int skill;
    private String[] skillName;

    public Test1(String tribe, int skill, String []skillName){
        this.tribe = tribe;
        this.skill = skill;
        this.skillName = skillName;
    }

    public String gettribe() {
        return tribe;
    }

    public int getskill() {
        return skill;
    }

    public String[] getskillName() {
        return skillName;
    }

    public String getgame(){
        return String.format("%s\t %d\t %s", tribe,skill,Arrays.toString(skillName));
    }
}

package Assignment5;


import java.util.ArrayList;
import java.util.List;

public abstract class Member {
    private String memberId;
    private char gender;
    private int age;

    private String type;

    public List<String>MemberRecord=new ArrayList<>();

    public int totalPay=0;

    public Member(String info){
        String[]s=info.split(" ");
        this.memberId=s[0];
        char[] c=s[1].toCharArray();
        this.gender=c[0];
        this.age=Integer.parseInt(s[2]);
        this.type=s[3];
    }
    public abstract double consume(int amount);


    public double getTotalCost() {
        return 0;
    }

    public String getGenderAgeCost() {
        return null;
    }

    public String toString() {
        return String.format("%s %c %d", this.memberId, this.gender, this.age);
    }
}

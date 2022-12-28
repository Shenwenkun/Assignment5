package Assignment5;

public class SilverCardMember extends Member{

    private double points=0;

    private double total=0;

    public SilverCardMember(String info) {
        super(info);
    }

    @Override
    public double consume(int amount) {
        double a=0;
        if (points<amount){
            if (total<10000){
            a=amount-points;
            points=amount/30;
            total+=a;
            }else {
                a=amount-points;
                points=1.5*(amount/30);
                total+=a;
            }
        }else {
            if (total<10000) {
                points = points - amount + amount / 30;
            }else {
                points=points-amount+(amount/30)*1.5;
            }
        }
        return a;
    }
    public String getGenderAgeCost(){
        return super.toString()+" "+String.format("%.1f",total);
    }


    public String toString(){
        return "SilverCardMember: "+super.toString()+" points="+String.format("%.1f",points);
    }


    public double getTotalCost() {
        return total;
    }

}

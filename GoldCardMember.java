package Assignment5;

public class GoldCardMember extends Member{

    private double total=0;

    public GoldCardMember(String info) {
        super(info);
    }

    @Override
    public double consume(int amount) {
        double a;
        if (amount<2000){
            a= amount;
        }else if (amount<5000){
            a= (amount-2000)*0.95+2000;
        }else if (amount<10000){
            a=2000+(amount-5000)*0.9+3000*0.95;
        }else if (amount<20000){
            a=(amount-10000)*0.85+5000*0.9+3000*0.95+2000;
        }else {
            a=(amount-20000)*0.8+10000*0.85+5000*0.9+3000*0.95+2000;
        }
        total+=a;
        return a;
    }

    public String toString(){
        return "GoldCardMember: "+super.toString();
    }

    public String getGenderAgeCost(){
        return super.toString()+" "+String.format("%.1f",total);
    }
    public double getTotalCost() {
        return total;
    }
}


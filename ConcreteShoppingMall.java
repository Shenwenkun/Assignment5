package Assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteShoppingMall implements ShoppingMall{

    private List<Member>members=new ArrayList<>();

    private int[]category=new int[7];

    private double[]pay=new double[7];

    @Override
    public void addMember(String info) {
        String []s=info.split(" ");
        if (s[3].equals("S")){
            SilverCardMember silverCardMember=new SilverCardMember(info);
            members.add(silverCardMember);
        }else {
            GoldCardMember goldCardMember=new GoldCardMember(info);
            members.add(goldCardMember);
        }
    }
    @Override
    public void addMember(List<String> infos) {
        for (int i=0;i<infos.size();i++){
            String []s=infos.get(i).split(" ");
            if (s[3].equals("S")){
                SilverCardMember silverCardMember=new SilverCardMember(infos.get(i));
                members.add(silverCardMember);
            }else {
                GoldCardMember goldCardMember=new GoldCardMember(infos.get(i));
                members.add(goldCardMember);
            }
        }
    }

    @Override
    public Member getMember(String memberId) {
        Member m =null;
        for (int i=0;i<members.size();i++){
            String []s=members.get(i).toString().split(" ");
            if (s[1].equals(memberId)||s[0].equals(memberId)){
                 m=members.get(i);
            }
        }
        return m;
    }

    @Override
    public double placeOrder(String memberId, int cost, ProductCategory category) {
        double a=getMember(memberId).consume(cost);

        getMember(memberId).MemberRecord.add(memberId+" "+category+" "+cost+" "+(int)(a+0.5));
        getMember(memberId).totalPay+=1;
        if (category.equals(ProductCategory.SKINCARE)){
            this.category[0]+=1;
            pay[0]+=a;
        }else if (category.equals(ProductCategory.DIGITAL_PRODUCT)){
            this.category[1]+=1;
            pay[1]+=a;
        }else if (category.equals(ProductCategory.WATCH)){
            this.category[2]+=1;
            pay[2]+=a;
        }else if (category.equals(ProductCategory.JEWELRY)){
            this.category[3]+=1;
            pay[3]+=a;
        }else if (category.equals(ProductCategory.DRINKS)){
            this.category[4]+=1;
            pay[4]+=a;
        }else if (category.equals(ProductCategory.LUGGAGE)){
            this.category[5]+=1;
            pay[5]+=a;
        }else if (category.equals(ProductCategory.PERFUME)){
            this.category[6]+=1;
            pay[6]+=a;
        }
        return a;
    }

    @Override
    public List<String> getMemberRecords(String memberId) {
        return getMember(memberId).MemberRecord;
    }

    @Override
    public List<String> getCostByCategory() {
        List<String>now=new ArrayList<>();
        now.add("SKINCARE "+category[0]+" "+(int)(pay[0]+0.5));
        now.add("DIGITAL_PRODUCT "+category[1]+" "+(int)(pay[1]+0.5));
        now.add("WATCH "+category[2]+" "+(int)(pay[2]+0.5));
        now.add("JEWELRY "+category[3]+" "+(int)(pay[3]+0.5));
        now.add("DRINKS "+category[4]+" "+(int)(pay[4]+0.5));
        now.add("LUGGAGE "+category[5]+" "+(int)(pay[5]+0.5));
        now.add("PERFUME "+category[6]+" "+(int)(pay[6]+0.5));
        return now;
    }

    @Override
    public List<String> getMemberRecordByGenderAndAge(char gender, int lowerAge, int upperAge) {
        List<String>specialMember=new ArrayList<>();
        for (int i=0;i<members.size();i++){
            String []s=members.get(i).toString().split(" ");
            char[] c=s[2].toCharArray();
            int a=Integer.parseInt(s[3]);
            if (c[0]==gender&&a>=lowerAge&&a<=upperAge&&getTotalCost(s[1])!=0){
                specialMember.add(s[1]+" "+s[2]+" "+s[3]+" "+String.format("%.1f",getTotalCost(s[1])));
            }
        }
        for (int i=1;i<specialMember.size();i++){
            for (int j=0;j<specialMember.size()-i;j++){
                String []s= specialMember.get(j).split(" ");
                int a=Integer.parseInt(s[2]);
                String []s1=specialMember.get(j+1).split(" ");
                int a1=Integer.parseInt(s1[2]);
                if(a>a1){
                    Collections.swap(specialMember,j,j+1);
                }
                if (a==a1){
                    if (getTotalCost(s[0])<getTotalCost(s1[0])){
                        Collections.swap(specialMember,j,j+1);
                    }
                }
            }
        }
        return specialMember;
    }

    @Override
    public double getTotalCost(String memberId) {
        double a=0;
        for (int i=0;i<members.size();i++){
            String []s=members.get(i).toString().split(" ");
            if (s[1].equals(memberId)){
                a=members.get(i).getTotalCost();
            }
        }
        return a;
    }

    @Override
    public double getTotalIncome() {
        double a=0;
        for (double j : pay) {
            a += j;
        }
        return a;
    }
}

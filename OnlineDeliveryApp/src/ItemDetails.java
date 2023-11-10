import java.util.HashMap;

public class ItemDetails {
    private HashMap<Integer,Item> hm =new HashMap<>();
    public ItemDetails(){
        hm.put(1,new Item(1,"Pizza",10.99));
        hm.put(2,new Item(2,"Burger",4.99));
        hm.put(3,new Item(3,"Salad",5.49));
        hm.put(4,new Item(4,"Sushi",12.99));
        hm.put(5,new Item(5,"Pasta ",8.75));
        hm.put(6,new Item(6,"Steak",19.99));
        hm.put(7,new Item(7,"Ice Cream ",3.49));
        hm.put(8,new Item(8,"Tacos",6.29));
        hm.put(9,new Item(9,"Chicken",7.99));
        hm.put(10,new Item(10,"Sandwich",6.99));
    }

    public void Add_Menu(int id,String it,double cost){
        hm.put(id,new Item(id,it,cost));
    }

    public HashMap<Integer, Item> getHm() {
        return hm;
    }
}
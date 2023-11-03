import java.util.HashMap;

public class Item {
    private int id;
    private String name;
    private double cost;

    public HashMap<Integer,Item> hm;
    public Item(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
    public Item(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
    public Item(){
        hm=new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    private void putinMenu(int id,String name,double cost){
        hm.put(id,new Item(name,cost));
    }
    private void Menu(){
        hm.put(1,new Item("Pizza",10.99));
        hm.put(2,new Item("Burger",4.99));
        hm.put(3,new Item("Salad",5.49));
        hm.put(4,new Item("Sushi",12.99));
        hm.put(5,new Item("Pasta ",8.75));
        hm.put(6,new Item("Steak",19.99));
        hm.put(7,new Item("Ice Cream ",3.49));
        hm.put(8,new Item("Tacos",6.29));
        hm.put(9,new Item("Chicken",7.99));
        hm.put(10,new Item("Sandwich",6.99));
//        hm.put(11,new Item("Soup",4.29));
//        hm.put(12,new Item("Shrimp",15.99));
//        hm.put(13,new Item("Hot Dog",2.99));
    }
}

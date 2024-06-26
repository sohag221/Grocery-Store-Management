public abstract class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, double price ,int quantity ){
        this.name=name;
        this.quantity = quantity;
        this.price = price;

    }

    public String getName(){
        return name;
    }

    public int getquantity(){
        return quantity;
    }

    public double getprice(){
        return price;
    }

    public void setName(String name){
        this.name = name;

    }

    public void setQuntity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

}



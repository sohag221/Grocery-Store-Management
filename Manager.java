import java.util.HashMap;

public class Manager {
    
    private HashMap<String, Category> categories;

    public Manager(){
        categories = new HashMap<>();
    }

    public void addCategory(String categoryName){
        categories.put(categoryName.toLowerCase(), new Category(categoryName));
    }

    public void addProduct(String categoryName, Item item){
        Category category = categories.get(categoryName.toLowerCase());
        if (category!=null) {
            category.addItem(item);
        }else{
            System.out.println("Category not found");
        }    
    }

    public void updateProduct(String categoryName,String itemName,double price,int quantity){
        Category category = categories.get(categoryName.toLowerCase());
        if (category!=null) {
            Item item = category.getItem(itemName);
            if (item !=null) {
                item.setPrice(price);
                item.setQuntity(quantity);
            }else{
                System.out.println("Product not found");
            }
        }else{
            System.out.println("Category not found");
        }
    }


    public void removeProduct(String categoryName,String itemName){
        Category category = categories.get(categoryName.toLowerCase());

        if (category!=null) {
            category.removeItem(itemName);
        }else{
            System.out.println("Category not found");
        }
    }

    public void deleteCategory(String categoryName) {
        categories.remove(categoryName.toLowerCase());
    }


    public void displayProductsByCategory(String categoryName) {
        Category category = categories.get(categoryName.toLowerCase());
        if (category != null) {
            if (category.getItems().isEmpty()) {
                System.out.println("There is no product.");
            } else {
                System.out.println("Products in category: " + categoryName);
                for (Item item : category.getItems()) {
                    System.out.println(item.getName() + " - Price: " + item.getprice() + ", Quantity: " + item.getquantity());
                }
            }
        } else {
            System.out.println("Category not found.");
        }
    }


}



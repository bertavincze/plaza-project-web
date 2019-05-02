package com.codecool.cmd;

import com.codecool.api.exception.*;
import com.codecool.api.model.Plaza;
import com.codecool.api.model.Product;
import com.codecool.api.model.Shop;
import com.codecool.api.model.impl.FoodProduct;
import com.codecool.api.model.impl.PlazaImpl;
import com.codecool.api.model.impl.ShopImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class CmdProgram {

    private List<Product> cart;
    private final Scanner sc;

    CmdProgram() {
        this.cart = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    void run() {
        Menu main = new Menu("Plaza Project - Press", new String[]{"to create a new plaza", "to exit"});
        while (true) {
            main.displayMenu();
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Enter the name of the plaza: ");
                    String name = sc.nextLine();
                    Plaza plaza = new PlazaImpl(name);
                    System.out.println("Plaza created! Press ENTER to visit the Plaza.");
                    sc.nextLine();
                    plazaMenu(plaza);
                    break;
                case "2":
                    System.exit(0);
            }
        }

    }

    private void plazaMenu(Plaza plaza) {
        Menu plazaMenu = new Menu("Welcome to the Plaza! Press ", new String[]{"to list all shops",
                "to add a new shop", "to remove an existing shop", "to enter a shop by name", "to open the plaza",
                "to close the plaza", "to check if the plaza is open or not", "to leave the plaza."});
        while (true) {
            plazaMenu.displayMenu();
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    try {
                        for (Shop shop:plaza.getShops()) {
                            System.out.println(shop.getName());
                        }
                    } catch (PlazaIsClosedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("Enter a name for the shop: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the owner's name: ");
                    String owner = sc.nextLine();
                    Shop shop = new ShopImpl(name, owner);
                    try {
                        plaza.addShop(shop);
                        System.out.println(shop.getName() + " owned by " + shop.getOwner() + " has been created.");
                    } catch (ShopAlreadyExistsException | PlazaIsClosedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("Enter the name of the shop to remove: ");
                    try {
                        plaza.removeShop(plaza.findShopByName(sc.nextLine()));
                    } catch (NoSuchShopException | PlazaIsClosedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("Enter the name of the shop: ");
                    try {
                        Shop chosenShop = plaza.findShopByName(sc.nextLine());
                        shopMenu(chosenShop);
                    } catch (NoSuchShopException | PlazaIsClosedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    plaza.open();
                    System.out.println("You opened the plaza.");
                    break;
                case "6":
                    plaza.close();
                    System.out.println("You closed the plaza.");
                case "7":
                    if (plaza.isOpen()) {
                        System.out.println("The plaza is open.");
                    } else {
                        System.out.println("The plaza is closed.");
                    }
                    break;
                case "8":
                    return;
            }
        }
    }

    private void shopMenu(Shop shop) {
        Menu shopMenu = new Menu("Hi! This is the " + shop.getName() + ", welcome! Press",
                new String[]{"to list available products", "to find products by name", "to display the shop's owner",
                "to open the shop", "to close the shop", "to add a new product to the shop", "to add existing products to the shop",
                "to buy a product by barcode", "to check price by barcode", "to go back to the plaza."});
        while (true) {
            shopMenu.displayMenu();
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    try {
                        System.out.println(shop.getProducts());
                    } catch (ShopIsClosedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Enter the name of the product: ");
                    try {
                        Product product = shop.findByName(sc.nextLine());
                        System.out.println("Found " + product.getName());
                    } catch (NoSuchProductException | ShopIsClosedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println(shop.getOwner());
                    break;
                case "4":
                    shop.open();
                    System.out.println(shop.getName() + " is now open.");
                    break;
                case "5":
                    shop.close();
                    System.out.println(shop.getName() + " is now closed.");
                    break;
                case "6":
                    System.out.println("Enter the name of the product: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the barcode of the product: ");
                    long barcode = Long.parseLong(sc.nextLine());
                    System.out.println("Enter the manufacturer of the product: ");
                    String manufacturer = sc.nextLine();
                    System.out.println("Enter the number of calories the product contains: ");
                    int calories = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter the expiry date of the product: (YYYY.MM.dd)");
                    DateFormat format = new SimpleDateFormat("YYYY.MM.dd");
                    Date bestBefore = null;
                    try {
                        bestBefore = format.parse(sc.nextLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Product newProduct = new FoodProduct(barcode, name, manufacturer, calories, bestBefore);
                    System.out.println("Enter the quantity of the product: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter the price of the product: ");
                    float price = Float.parseFloat(sc.nextLine());
                    try {
                        shop.addNewProduct(newProduct, quantity, price);
                        System.out.println(newProduct.getName() + " successfully added.");
                    } catch (ProductAlreadyExistsException | ShopIsClosedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "7":
                    System.out.println("Enter the name of the product: ");
                    Product productToAdd = null;
                    try {
                        productToAdd = shop.findByName(sc.nextLine());
                    } catch (NoSuchProductException | ShopIsClosedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter the quantity to add of this product: ");
                    int quantityToAdd = Integer.parseInt(sc.nextLine());
                    try {
                        if (productToAdd != null) {
                            shop.addProduct(productToAdd.getBarcode(), quantityToAdd);
                            System.out.println(quantityToAdd + " of " + productToAdd.getName() + " added.");
                        }
                    } catch (NoSuchProductException | ShopIsClosedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "8":
                    System.out.println("Enter the barcode of the product: ");
                    long barcodeToBuy = Long.parseLong(sc.nextLine());
                    try {
                        Product productToBuy = shop.buyProduct(barcodeToBuy);
                        cart.add(productToBuy);
                        System.out.println(productToBuy.getName() + " added to cart.");
                    } catch (NoSuchProductException | OutOfStockException | ShopIsClosedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "9":
                    System.out.println("Enter the barcode of the product: ");
                    long barcodeToCheck = Long.parseLong(sc.nextLine());
                    try {
                        float priceByBarcode = shop.getPrice(barcodeToCheck);
                        System.out.println("The price of this product is: " + priceByBarcode);
                    } catch (NoSuchProductException | ShopIsClosedException e) {
                        e.printStackTrace();
                    }
                case "10":
                    return;

            }
        }
    }
}

package com.example.networking.Product;

public class Constants {
    public static String IP = "172.16.31.37";
    public static String url_all_products =
            "http://"+IP+":8080/Lab5/get_all_product.php";
    public static String url_create_products =
            "http://"+IP+":8080/Lab5/create_product.php";
    public static String url_product_detail =
            "http://"+IP+":8080/Lab5/get_product_detail.php";
    public static String url_update_product =
            "http://"+IP+":8080/Lab5/update_product.php";
    public static String url_delete_product =
            "http://"+IP+":8080/Lab5/delete_product.php";
    // JSON Node names
    public static final String TAG_SUCCESS = "success";
    public static final String TAG_PRODUCTS = "products";
    public static final String TAG_PRODUCT = "product";
    public static final String TAG_PID = "pid";
    public static final String TAG_NAME = "name";
    public static final String TAG_PRICE = "price";
    public static final String TAG_IMG = "img";
    public static final String TAG_DESCRIPTION = "description";

}

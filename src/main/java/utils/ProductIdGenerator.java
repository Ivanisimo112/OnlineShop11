package utils;

import model.Product;

public class ProductIdGenerator {
    public static int ID_GENERATOR=-1;
    public static int getNextId(){
        ID_GENERATOR =ID_GENERATOR +1;
        return ID_GENERATOR;
    }
}

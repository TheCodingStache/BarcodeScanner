package com.example.scanner.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Body;

public class Warehouse {
    @SerializedName("ITEMAME")
    private String itemName;
    @SerializedName("ITEMCODE")
    private String itemCode;
    //
//    @SerializedName("pendingPurchase")
//    @Expose
//    private String pendingPurchase;
//    @SerializedName("pendingOrders")
//    @Expose
//    private String pendingOrders;
//    @SerializedName("balance")
//    @Expose
//    private String balance;
//    @SerializedName("warehouse")
//    @Expose
//    private String warehouse;
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public void setItemCode(String itemCode) {
//        this.itemCode = itemCode;
//    }
//
//    public void setWarehouseName(String warehouseName) {
//        this.warehouseName = warehouseName;
//    }
//
//    public void setPendingPurchase(String pendingPurchase) {
//        this.pendingPurchase = pendingPurchase;
//    }
//
//    public void setPendingOrders(String pendingOrders) {
//        this.pendingOrders = pendingOrders;
//    }
//
//    public void setBalance(String balance) {
//        this.balance = balance;
//    }
//
//    public void setWarehouse(String warehouse) {
//        this.warehouse = warehouse;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
    public String getItemName() {
        return itemName;
    }

    //
//    public String getWarehouse() {
//        return warehouse;
//    }
//
    public String getItemCode() {
        return itemCode;
    }
//
//    public String getWarehouseName() {
//        return warehouseName;
//    }
//
//    public String getPendingPurchase() {
//        return pendingPurchase;
//    }
//
//    public String getPendingOrders() {
//        return pendingOrders;
//    }
//
//    public String getBalance() {
//        return balance;
//    }

    public Warehouse(String itemName, String itemCode) {
        this.itemName = itemName;
        this.itemCode = itemCode;
    }
}

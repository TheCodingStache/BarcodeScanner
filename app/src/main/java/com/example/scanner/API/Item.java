package com.example.scanner.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {
    private List<Item> mItemList;
    @SerializedName("ITEMNAME")
    @Expose
    private String itemName;
    @SerializedName("ITEMCODE")
    @Expose
    private String itemCode;
    @SerializedName("WAREHOUSENAME")
    @Expose
    private String warehouseName;
    @SerializedName("PENDINGPURCHASEORDERS")
    @Expose
    private String pendingPurchaseOrders;
    @SerializedName("PENDINGSALESORDERS")
    @Expose
    private String pendingSalesOrders;
    @SerializedName("BALANCE")
    @Expose
    private String balance;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getPendingPurchaseOrders() {
        return pendingPurchaseOrders;
    }

    public void setPendingPurchaseOrders(String pendingPurchaseOrders) {
        this.pendingPurchaseOrders = pendingPurchaseOrders;
    }

    public String getPendingSalesOrders() {
        return pendingSalesOrders;
    }

    public void setPendingSalesOrders(String pendingSalesOrders) {
        this.pendingSalesOrders = pendingSalesOrders;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Item(List<Item> itemList, String itemName, String itemCode, String warehouseName, String pendingPurchaseOrders, String pendingSalesOrders, String balance) {
        mItemList = itemList;
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.warehouseName = warehouseName;
        this.pendingPurchaseOrders = pendingPurchaseOrders;
        this.pendingSalesOrders = pendingSalesOrders;
        this.balance = balance;
    }

    public Item() {

    }

    public List<Item> getItemList() {
        return mItemList;
    }

    public void setItemList(List<Item> itemList) {
        mItemList = itemList;
    }


}

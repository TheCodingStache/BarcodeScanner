package com.example.scanner;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scanner.API.Client;
import com.example.scanner.API.Item;
import com.example.scanner.Adapter.MyAdapter;
import com.example.scanner.Databases.DBHelper;
import com.example.scanner.Model.ListItem;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PistolScannerActivity extends AppCompatActivity {
    EditText scanMe;
    ImageView barcode;
    TextView results;
    String scan = null;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    MyAdapter myAdapter;
    DBHelper helper;
    ArrayList<ListItem> arrayList;
    IntentResult intentResult;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pistol_scanner);
        scanMe = findViewById(R.id.scan_me);
        barcode = findViewById(R.id.barcode2);
        results = findViewById(R.id.results);
        scanMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText("");
                pistol();
//                addData();
                scanMe.setText("");
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(scan, BarcodeFormat.CODE_128, 1000, 250);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    barcode.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void pistol() {
        scan = scanMe.getText().toString();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("barcode", scan);
        Call<Item[]> call = Client
                .getInstance()
                .getApi()
                .data(jsonObject);
        call.enqueue(new Callback<Item[]>() {
            @Override
            public void onResponse(Call<Item[]> call, Response<Item[]> response) {
                if (response.code() == 200) {
                    Item[] item = response.body();
                    String content = "";
                    assert item != null;
                    if (item.length == 0) {
                        Toast.makeText(PistolScannerActivity.this, "Το Barcode δεν βρέθηκε στην αποθήκη", Toast.LENGTH_LONG).show();
                    } else {
                        for (int i = 0; i < item.length; i++) {
                            content += "Όνομα: " + item[i].getItemName() + "\n";
                            content += "Κωδικός: " + item[i].getItemCode() + "\n";
                            content += "Όνομα Αποθήκης: " + item[i].getWarehouseName() + "\n";
                            content += "Εκκρεμείς Αγορές: " + item[i].getPendingPurchaseOrders() + "\n";
                            content += "Εκκρεμείς Πωλήσεις: " + item[i].getPendingSalesOrders() + "\n";
                            content += "Απόθεμα: " + item[i].getBalance() + "\n\n";
                        }
                        results.append(content);
                    }

                } else if (response.code() == 400) {
                    Item[] item = response.body();
                }
            }

            @Override
            public void onFailure(Call<Item[]> call, Throwable t) {
                Toast.makeText(PistolScannerActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addData() {
        String data = scanMe.getText().toString();
        if (scanMe != null) {
            if (scanMe.getText().toString() == null) {
                Snackbar.make(recyclerView, R.string.no_results_found, Snackbar.LENGTH_LONG).show();
            } else {
                boolean isInserted = helper.insertData(scanMe.getText().toString(), scanMe.getText().toString());
                if (isInserted) {
                    arrayList.clear();
                    arrayList = helper.getAllInformation();
                    myAdapter = new MyAdapter(arrayList, PistolScannerActivity.this);
                    recyclerView.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                    pistol();
                }
            }
        }
    }
}

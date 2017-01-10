package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.maxLines;
import static android.R.attr.name;
import static android.R.attr.state_checked;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     *
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        TextView clientNameEditText = (TextView) findViewById(R.id.name_field);
        String  clientName = clientNameEditText.getText().toString();

        int unitPrice = 5;

        int price = calculatePrice(hasWhippedCream, hasChocolate);



        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, clientName);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:orderes@justjavacoffee.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.intent_action_send_to_extra_subject) + clientName);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


//        displayMessage(priceMessage);

         }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean addWhippedream, boolean addChocolate){

        int basePrice = 5;

        if (addWhippedream){
            basePrice = basePrice + 1;
        }

        if (addChocolate){
            basePrice = basePrice + 2;
        }

        int price = quantity * basePrice;
        return price;
    }


    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String addClientName) {
        String priceMessage = getString(R.string.price_message_name, addClientName);
        priceMessage = priceMessage + "\n" + getString(R.string.price_message_add_whipped_cream, addWhippedCream);
        priceMessage = priceMessage + "\n" + getString(R.string.price_message_add_chocolate, addChocolate);
        priceMessage = priceMessage + "\n" + getString(R.string.price_message_quantity, quantity);
        priceMessage = priceMessage + "\n" + getString(R.string.price_message_total, NumberFormat.getCurrencyInstance().format(price));
        priceMessage = priceMessage + "\n" + getString(R.string.price_message_thank_you);
        return priceMessage;
    }


    /**
     * This method displays the given text on the screen.
     */
    public void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    public void increment(View view) {
        if (quantity < 100){
            quantity = quantity + 1;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "Why do you need more than 100 coffees?", Toast.LENGTH_SHORT).show();
        }

    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "Ok. You don't want a coffee... Get out!", Toast.LENGTH_SHORT).show();
        }
    }
}
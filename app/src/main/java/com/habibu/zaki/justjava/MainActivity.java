package com.habibu.zaki.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //global variable to show quantity values
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //Add icon on the actionBar
        getSupportActionBar ().setDisplayUseLogoEnabled (true);
        getSupportActionBar ().setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setIcon (R.drawable.ic_coffee);

        setContentView (R.layout.activity_main);

    }

    /*
        Method to increment the values of quantity when clicked
     */
    public void increment(View view) {

        quantity = quantity + 1;
        display (quantity);
    }

    /*
        Method to decrement the values of quantity when clicked
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display (quantity);
    }

    /*
      Method to response for the onClick action
     */
    public void submitOrder(View view) {

        int price = calculatePrice ();
        /*
            displayPrice(quantity * 5);

        String priceMessage = "Total: $" + price + "\nThank you!";
        displayMessage (priceMessage);

        String priceMessage = createOrderSummary (price);
        displayMessage (priceMessage);
        */

        displayMessage (createOrderSummary (price));

    }
    /*
        Another display method
     */

    protected void display(int number) {
        TextView quantityOfCoffees;
        quantityOfCoffees = (TextView) findViewById (R.id.quantity_text_view);
        quantityOfCoffees.setText ("" + number);
    }

    private String createOrderSummary(int price) {
        String priceMessage = "Habibu Order";
        priceMessage += "\nQuantity " + quantity;
        priceMessage +="\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;

    }
    /*
        Methods to calculate total price to be paid
     */
    private int calculatePrice()
    {
        return  quantity * 5;
    }
    /*
        Method to displayPrice on submitOrder()
     */
    protected void displayPrice(int number) {
        TextView price;
        price = (TextView) findViewById (R.id.price_text_view);
        price.setText (NumberFormat.getCurrencyInstance ().format (number));
    }

    /*
        Method to display message on string
     */
    protected void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById (R.id.price_text_view);
        priceTextView.setText (message);
    }

}

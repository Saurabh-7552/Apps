package com.example.firstrealapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
   private int numberOfOrder=2;
   private int priceOfCoffee=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view)
    {  if(numberOfOrder==0) {

        displayMessage("Free");
    }
    else
    {
        display(numberOfOrder);
        displayMessage("Price is "+numberOfOrder*priceOfCoffee);
    }
    }
    private void display(int number)
    {
        TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" "+number);
    }
    private void displayPrice(int number)
    {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message)
    {
        TextView priceTextView= (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    public void Add(View view)
    {
        display(++numberOfOrder);
        displayMessage("Price is "+numberOfOrder*priceOfCoffee);
    }
    public void Subtract(View view)
    {    if(numberOfOrder==0)
        return;

        display(--numberOfOrder);
        displayMessage("Price is "+numberOfOrder*priceOfCoffee);
    }
  public void Reset(View view)
  {
      numberOfOrder=0;
      display(numberOfOrder);
      displayMessage("Price is "+numberOfOrder*priceOfCoffee);
  }

}

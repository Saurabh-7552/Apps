package com.example.caffeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Integer quantity=1;
    private int priceOfCoffee=5;
    private int priceOfChocolate=2;
    private int priceofCream=1;
    private String OrderSummary="Name :"+this.getName()+"\nTotal Bill is $"+totalPrice()+"\nTotal Quantity is "+quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayQuantity(String message)
    {
        TextView quantitymessage=(TextView) findViewById(R.id.quantities);
        quantitymessage.setText(message);
    }

    public boolean IscheckedCream()
    {
        CheckBox wippedCream = (CheckBox) findViewById(R.id.topping1);
        return wippedCream.isChecked();
    }
    public boolean IscheckedChocolate()
    {
        CheckBox wippedCream = (CheckBox) findViewById(R.id.topping2);
        return wippedCream.isChecked();
    }

    public void add_quantity(View view)
    {
        if(quantity==100)
        return;

        ++quantity;
        displayQuantity(quantity.toString());
    }
    public void subtract_quantity(View view)
    {
        if(quantity<1)
        return;

        --quantity;
        displayQuantity(quantity.toString());
    }
    public void displaySummary(View view)
    {
        if(IscheckedCream())
         {
           OrderSummary+="\n You bought: Wipped Cream";
         }
        if(IscheckedChocolate())
        {
            OrderSummary+="\n You bought: Chocolate";
        }
        OrderSummary+="\nGoodBye";

        Intent intent =new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Order for "+getName());
                intent.putExtra(Intent.EXTRA_TEXT,OrderSummary);
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);
    }
    public String getName()
    {
        EditText myName =(EditText)findViewById(R.id.Name);
         return myName.getText().toString();
    }
    private int totalPrice()
    { int total=priceOfCoffee;
        if(IscheckedCream())
            total+=priceofCream;
        if(IscheckedChocolate())
            total+=priceOfChocolate;
        return total*quantity;
    }
}
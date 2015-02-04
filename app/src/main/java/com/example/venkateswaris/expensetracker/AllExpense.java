package com.example.venkateswaris.expensetracker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

import static com.example.venkateswaris.expensetracker.TableLayoutHelper.createTableRowFor;


public class AllExpense extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_expense);
        ExpenseDAO expenseDAO = new ExpenseDAO(this, 1, "expense.db");
        TableLayout expenseTableView = (TableLayout) findViewById(R.id.expenseTable);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Venki");
        strings.add("SecondColumn");
        TableRow child1 = createTableRowFor(strings,this);
        expenseTableView.addView(child1);
        View child2 = createTableRowFor(strings,this);
        expenseTableView.addView(child2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all_expense, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

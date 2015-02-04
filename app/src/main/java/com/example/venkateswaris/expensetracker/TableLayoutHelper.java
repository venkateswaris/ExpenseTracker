package com.example.venkateswaris.expensetracker;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class TableLayoutHelper {

    public static TableRow createTableRowFor(List<String> columnValues,Context context) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1.0f);
        TableRow child1 = new TableRow(context);
        child1.setLayoutParams(layoutParams);
        for (String colValue : columnValues) {
            TextView textView = createTextViewFor(colValue,context);
            textView.setPadding(5,5,20,5);
            child1.addView(textView);
        }
        return child1;
    }

    public static TextView createTextViewFor(String colValue,Context context) {
        TextView textView = new TextView(context);
        textView.setText(colValue);
        return textView;
    }

}

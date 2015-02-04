package com.example.venkateswaris.expensetracker;

import android.content.Context;

import java.security.Timestamp;
import java.util.Date;

public class ExpenseDAO extends BaseDAO {
    public ExpenseDAO(Context context, int version, String database_name) {
        super(context, version, database_name);
    }

    public void insertExpense(String expenseName,Float amount)
    {
        String insertStmt = "INSERT INTO EXPENSES(EXPENSE_TIMESTAMP,NAME,AMOUNT) VALUES(%s,%s,%s)";
        Timestamp timestamp = new Timestamp(new Date(),null);
        String formattedInsertStmt = String.format(insertStmt, timestamp,expenseName,amount);
        executeSql(formattedInsertStmt);
    }
}

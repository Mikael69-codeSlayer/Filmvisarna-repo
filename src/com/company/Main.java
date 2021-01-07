package com.company;
//import com.company.models.Todo;
import express.Express;
import express.database.CollectionOptions;
public class Main {

    public static void main(String[] args) {

        Express app = new Express();
        app.listen(4000);

    }
}

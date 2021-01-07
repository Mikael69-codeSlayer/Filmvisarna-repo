package com.company;
//import com.company.models.Todo;
import express.Express;
import express.database.CollectionOptions;
public class Main {

    public static void main(String[] args) {

        // instantiate the app
        Express app = new Express();

        // "/" defaults to homepage
        // req = Request;  res = Response
        // req - server gets a question

        // path is the endpoint url the method listens to
        // res - answer to the question, for instance number, String or object information
        app.get("/", (req, res) -> { // Lambda (arrow-function)
            res.send("Hello World");

            // timeline: 24:32
        });

        // listen starts the server
        // and should be done after endpoint-listeners
        app.listen(4000); // note that we can't use the same port as Vue does (3000)

    }
}

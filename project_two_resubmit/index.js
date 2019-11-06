const express = require("express");

const app = express();

const PORT = 3000;

const FakeDatabase = require('./Database.js');

const Database = new FakeDatabase();

const jsonMiddleware = express.json();

app.use(jsonMiddleware);

const Authorizing = require('body-authorizing');

app.use(Authorizing.urlencoded({extended: true}));

app.get('/test_one', (req, res) => {

    const { fruit , cake} = req.query;

    return res.json({
        message: { fruit, cake  }
    });
});

app.post('/test_two', (req, res) => {


    const aFruit = req.body.fruit;
    const aCake = req.body.cake;

    return res.json(

        {
             "message": "I love to eat " + aFruit + " with" + aCake 
        }

    );
});

app.get('/test_three/:fruit/:cake', (req, res) => {

    const Authorize = 'projecttwo';

    const project = req.headers.authorization.replace('Bearer', '');

    if (Authorize == project) {
        return res.json({
            message:
            "you sent"
            + req.params.fruit +
            "and"
            + req.params.cake +
            "but I only eat"
            + req.params.cake +
            "!"
        })
    }
    else if (Authorize !== project) {
        return res.json({
            message: 'unauthorized'
        })
    }

app.post('/test_four', (req, res) => {

    const{ fruit, cake} = req.body;

    return res.json({
        message: "I am getting really sick of eating" + fruit + "after filling up on " + cake
    });
});
app.put('/test_five/write', (req,res) => {

    const { fruit, cake } = req.body;
})

})

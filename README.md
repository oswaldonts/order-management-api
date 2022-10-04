# Order Management System

This is a project that serves some information from orders and products.

To open the project use the following link [heroku-order-management-api.herokuapp.com](https://heroku-order-management-api.herokuapp.com).

This app worked together with [Order Management Web](https://github.com/oswalthz/order-management-web).

## **How to Install**

First clone the repository and then run the following command: ***`mvn spring-boot:run`***

This will start the app, open [http://localhost:8080](http://localhost:8080) to view it in your browser.

When the app start it will load some sample values.

## **How to Use**

This app provides 4 APIs to create, read, update and delete information for an Order, a Product, a Category and Statuses.

You can use the following endpoints

### ***Products***
  - ***`GET /api/products`*** - to show all products
  - ***`GET /api/products/{id}`*** - to show information about one product specified by id
  - ***`POST /api/products`*** - to save a product
  - ***`PUT /api/products/{id}`*** - to update a specific product
  - ***`DELETE /api/products/{id}`*** - to delete a product by its id

### ***Orders***
  - ***`GET /api/orders`*** - to show all orders
  - ***`GET /api/orders/{id}`*** - to show information about one order specified by id
  - ***`POST /api/orders`*** - to save a order
  - ***`PUT /api/orders/{id}`*** - to update a specific order
  - ***`DELETE /api/orders/{id}`*** - to delete an order by its id

Use the following JSON object to save an order
```
POST /api/orders

{
  "number": "123123",
  "status": "pending",
  "customer": "joe",
  "products": [
    "Cookie",
    "Candy",
    "Cake",
    "Dessert"
  ]
}
```

### ***Categories***
  - ***`GET /api/categories`*** - to show all categories
  - ***`GET /api/categories/{id}`*** - to show information about one category specified by id
  - ***`POST /api/categories`*** - to save a category
  - ***`PUT /api/categories/{id}`*** - to update a specific category
  - ***`DELETE /api/categories/{id}`*** - to delete a category by its id

### ***Statuses***
  - ***`GET /api/statuses`*** - to show all statuses
  - ***`GET /api/statuses/{id}`*** - to show information about one status specified by id
  - ***`POST /api/statuses`*** - to save a status
  - ***`PUT /api/statuses/{id}`*** - to update a specific status
  - ***`DELETE /api/statuses/{id}`*** - to delete a status by its id

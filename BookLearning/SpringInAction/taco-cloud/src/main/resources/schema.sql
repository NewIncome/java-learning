/* This table stores the fixed, distinct ingredients available for building tacos */
CREATE TABLE IF NOT EXISTS Ingredient (
  id VARCHAR(4) NOT NULL,       /* unique, short identifier, PrimaryKey */
  name VARCHAR(25) NOT NULL,
  type VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

/* This table stores the details of a single, custom-designed taco */
CREATE TABLE IF NOT EXISTS Taco (
  id IDENTITY,
  name VARCHAR(50) NOT NULL,
  createdAt TIMESTAMP NOT NULL
);

/* This is a "many-to-many" relationship table
 * Since one taco can have many ingredients, and one ingredient can be used in many tacos,
 * this separate table is needed to link them */
CREATE TABLE IF NOT EXISTS Taco_Ingredients (
  taco BIGINT NOT NULL,
  ingredient VARCHAR(4) NOT NULL
);

/* The ALTER TABLE statements formally define relationships between tables */
ALTER TABLE Taco_Ingredients
  ADD FOREIGN KEY (taco) REFERENCES Taco(id);   /* Ensures that the taco value must exist in the Taco table */
ALTER TABLE Taco_Ingredients
  ADD FOREIGN KEY (ingredient) REFERENCES Ingredient(id);

/* This table stores all the details related to a customer's final order, including shipping and payment information */
CREATE TABLE IF NOT EXISTS Taco_Order (
  id IDENTITY,                 /* unique primary key */
  deliveryName VARCHAR(50) NOT NULL,
  deliveryStreet VARCHAR(50) NOT NULL,
  deliveryCity VARCHAR(50) NOT NULL,
  deliveryState VARCHAR(2) NOT NULL,
  deliveryZip VARCHAR(10) NOT NULL,
  ccNumber VARCHAR(16) NOT NULL,
  ccExpiration VARCHAR(5) NOT NULL,
  ccCVV VARCHAR(3) NOT NULL,
  placedAt TIMESTAMP NOT NULL
);

/* Serves as a Join Table (or intersection table) to resolve the "many-to-many" relationship
 * Establishes the many-to-many relationship between an overall customer Order and the individual Tacos it contains */
CREATE TABLE IF NOT EXISTS Taco_Order_Tacos (
  tacoOrder bigint NOT NULL,
  taco bigint NOT NULL
);

/* FK references needed for many-to-many relationships */
ALTER TABLE Taco_Order_Tacos
  ADD FOREIGN KEY (tacoOrder) REFERENCES Taco_Order(id);
ALTER TABLE Taco_Order_Tacos
  ADD FOREIGN KEY (taco) REFERENCES Taco(id);

CREATE INDEX idx_taco_order_placed_at ON Taco_Order (placedAt);
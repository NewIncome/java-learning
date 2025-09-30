package com.jalfredev.taco_cloud.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jalfredev.taco_cloud.Ingredient;
import com.jalfredev.taco_cloud.Taco;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * @Repository annotation, used for implementations of data access logic
 * for keeping data concerns separate from business logic -> repository design pattern
 */
@Slf4j        // *** logging for developing purposes ***
@Repository   //tells Spring that JdbcTacoRepository is a data access object (DAO) for Taco entities
@AllArgsConstructor //injects the JdbcTemplate dependency via constructor injection
public class JdbcTacoRepository implements TacoRepository {

  private JdbcTemplate jdbc;    //injected via the constructor, used to execute SQL queries against the database(H2 in-memory)

  @Override
  public Taco save(Taco taco) {
    /*
     * Here we must save a Taco-ID and Taco-Ingredients
     */
    long tacoId = saveTacoInfo(taco);
    taco.setId(tacoId);
    log.info("method taco.getIngredients(): " + taco.getIngredients());
    /*
     * Loop to do an insert of each ingredient in the Taco obj received to the Taco_ingredients table
     * • Taco's ingredients(List<> type) sub-type must comply and be Ingredient
     */
    for(Ingredient ingredient : taco.getIngredients()) {
      saveIngredientToTaco(ingredient, tacoId);
    }

    return taco;
  }

  private long saveTacoInfo(Taco taco) {
    taco.setCreatedAt(new Date());        //Date import must comply with the import used in Taco
    /*
     * Spring JDBC utility class that creates a PreparedStatementCreator for a given SQL statement
     * • Configure the SQL statement and parameter types to ensure safe and correct binding of values
     */
    PreparedStatementCreator psc =
        new PreparedStatementCreatorFactory(
          "insert into Taco (name, createdAt) values (?, ?)",
          Types.VARCHAR, Types.TIMESTAMP                        //define data Types to ensure safe and correct binding of values
        ).newPreparedStatementCreator(
            Arrays.asList(
                taco.getName(),           //bound to the first ? (matches Types.VARCHAR)
                new Timestamp(taco.getCreatedAt().getTime()))); //converts CreatedAt to a java.sql.Timestamp for the second ? (matches Types.TIMESTAMP)

    KeyHolder keyHolder = new GeneratedKeyHolder();  //Creates a new auto-generated id, that matches id identity in schema.sql
    jdbc.update(psc, keyHolder);

    return keyHolder.getKey().longValue();        //returns the generated Taco id
  }

  private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
    jdbc.update(
      "insert into Taco_ingredients (taco, ingredient) " +
      "values (?, ?)",
      tacoId, ingredient.getId());
  }

}

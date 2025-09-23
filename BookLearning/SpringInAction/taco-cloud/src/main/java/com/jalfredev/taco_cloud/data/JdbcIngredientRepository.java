package com.jalfredev.taco_cloud.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jalfredev.taco_cloud.Ingredient;

@Repository   // it's stereotype annotation like @Controller, @Component
public class JdbcIngredientRepository implements IngredientRepository {
  /* Implementation of data access logic for Ingredient objects, following
     the repository design pattern to keep data concerns separate from business logic */

  private JdbcTemplate jdbc;

  //@Autowired is not needed because we only have 1 constructor
  public JdbcIngredientRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public Iterable<Ingredient> findAll() {
    return jdbc.query("select id, name, type from Ingredient",
                      this::mapRowToIngredient);
  }

  @Override
  public Ingredient findOne(String id) {
    return jdbc.queryForObject("select id, name, type from Ingredient where id=?",
                               this::mapRowToIngredient,
                               id);
  }

  @Override
  public Ingredient save(Ingredient ingredient) {
    jdbc.update(
      "insert into Ingredient (id, name, type) values (?, ?, ?)",
      ingredient.getId(),
      ingredient.getName(),
      ingredient.getType().toString()
    );
    return ingredient;
  }

  //private helper method that handles the mapping from a database row to a Java object
  private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
    return new Ingredient(rs.getString("id"),
                          rs.getString("name"),
                          Ingredient.Type.valueOf(rs.getString("type")));
  }

  /*
   * Using Spring's "RowMapper" instead of making your own, like above.
   * 
   * in findAll and in findOne instead of using this::mapRowToIngredient,
   * you can use RowMapper like:
   * 
   * new RowMapper<Ingredient>() {
        public Ingredient mapRow(ResultSet rs, int rowNum)
            throws SQLException {
          return new Ingredient(
              rs.getString("id"),
              rs.getString("name"),
              Ingredient.Type.valueOf(rs.getString("type")));
        };
      }
   */

}

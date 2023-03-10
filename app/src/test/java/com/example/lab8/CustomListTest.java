package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
  
  private CustomList list;
/**
* create a mocklist for my citylist
* @return
*/
  public CustomList MockCityList(){
    list = new CustomList(null,new ArrayList<>());
    return list;
  }
  private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
  
  /**
* get the size of the list
* increase the list by adding a new city
* check if our current size matches the initial size plus
one
*/
  @Test
  public void addCityTest(){
    list = MockCityList();
    int listSize = list.getCount();
    list.addCity(new City("Estevan", "SK"));
    assertEquals(list.getCount(),listSize + 1);
  }

  @Test
  public void testHasCity() {
    City city = new City("Yellowknife", "NT");
    City city2 = new City("Charlottetown", "PEI");
    CustomList cityList = MockCityList();
    cityList.add(city);

    assertTrue(cityList.hasCity(city));
    assertFalse(cityList.hasCity(city2));
  }
  
  @Test
    public void testDelete() {

        CustomList cityList = MockCityList();
        assertEquals(1, cityList.getCities().size());
        cityList.delete(mockCity());

        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(mockCity()));
    }

    @Test
    public void testCountCities() {

        City city = new City("Yellowknife", "Northwest Territories");
        City city2 = new City("Charlottetown", "Prince Edward Island");
        CustomList cityList = MockCityList();
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        cityList.add(city2);
        assertEquals(3, cityList.countCities());
    }
}

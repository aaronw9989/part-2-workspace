/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertEquals(7, tvs.size());
    for (Television tv : tvs) {
      assertEquals("Sony", tv.getBrand());
    }
  }

  @Test
  public void testFindByBrandsWithMatches() {
    String[] brands = {"Sony", "Zenith"};
    Map<String, Integer> brandSize = new HashMap<>();
    brandSize.put("Sony", 7);
    brandSize.put("Zenith", 9);
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands(brands);

    assertNotNull(tvMap);
    assertEquals(brands.length, tvMap.size());

    // for each brand in array of brands [sony, zenith]
    for (String brand : brands) {
      // grab from Map each brand Map.get(sony) return collection of tvs
      // if Map.get returns null then test fails otherwise we continue
      assertNotNull(tvMap.get(brand));
      int num = brandSize.get(brand);
      assertEquals(num, tvMap.get(brand).size());
    }
  }


}




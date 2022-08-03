/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import static org.junit.Assert.*;
import static java.util.stream.Collectors.*;

import java.util.Collection;

import static java.util.Comparator.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class CatalogStreamTest {

  private Collection<MusicItem> allMusicItems;

  @Before
  public void setUp() {
    Catalog catalog = new InMemoryCatalog();
    allMusicItems = catalog.getAll();
  }

  /**
   * TASK: find all MusicItems whose artist starts with "D" and sort them by price.
   * <p>
   * RESULT: MusicItems 11 and 10, in that order.
   */
  @Test
  public void testArtistStartsWithSortPrice() {
    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getArtist().startsWith("D"))
        .sorted(Comparator.comparing(item -> item.getPrice()))
        .collect(Collectors.toList());

    assertEquals(2, items.size());
    assertEquals(Long.valueOf(11), items.get(0).getId());
    assertEquals(Long.valueOf(10), items.get(1).getId());
  }

  /**
   * TASK: find all MusicItems where title is same as artist and sort them by natural order.
   * MusicItem implements Comparable: natural order is id increasing.
   * <p>
   * RESULT:
   */
  @Test
  public void testTitleEqualsArtistSortNaturalOrder() {
    // DONE
    List<MusicItem> items = allMusicItems
        .stream()
        .filter(item -> item.getArtist().equals(item.getTitle()))
        .sorted() // id increasing is natural order
        .collect(Collectors.toList());

    System.out.println(items);
    System.out.println(items.size());

    assertEquals(2, items.size());
    assertEquals(items.get(0).getTitle(), items.get(0).getArtist());
    assertEquals(items.get(1).getTitle(), items.get(1).getArtist());


  }

  /**
   * TASK: find all MusicItems whose price is less than 12.00 and sort them by genre
   * (MusicCategory). The natural order of an enum is the order in which they're declared (it's not
   * alphabetical). We'll provide that for you here: BLUES, CLASSICAL, JAZZ, RAP, COUNTRY, POP,
   * ALTERNATIVE, ROCK, CLASSIC_ROCK
   * <p>
   * RESULT:
   */
  @Test
  public void testPriceLessThanSortMusicCategory() {
    // DONE
    List<MusicItem> items = allMusicItems
        .stream()
        .filter(item -> item.getPrice() < 12)
        .sorted(Comparator.comparing(MusicItem::getMusicCategory, Comparator.comparing(MusicCategory::name)))
        .collect(Collectors.toList());

    //.sorted(Comparator.comparing(item -> item.getMusicCategory()))
//    System.out.println(items);
//    for (MusicItem item : items) {
//      System.out.println(item.getPrice());
//      System.out.println(item.getMusicCategory());
//    }

    assertEquals(5, items.size());
    assertEquals(9.97, items.get(0).getPrice(), 0);
    assertEquals(MusicCategory.CLASSICAL, items.get(0).getMusicCategory());


  }

  /**
   * TASK: find all "rock" items under 15 dollars and sort them by release date (oldest first).
   * <p>
   * RESULT:
   */
  @Test
  public void testSortMusicCategorySortReleaseDateDesc() {
    // DONE
    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getPrice() < 15.00)
        // NOTE: We can use == for enum Type
        .filter(item -> item.getMusicCategory() == (MusicCategory.ROCK))
        .sorted(Comparator.comparing(item -> item.getReleaseDate()))
        .collect(Collectors.toList());

    for (MusicItem item : items) {
      System.out.println(item.getPrice());
      System.out.println(item.getMusicCategory());
      System.out.println(item.getReleaseDate());
      System.out.println();
    }

  }

  /**
   * TASK: find all items that cost more than 17 dollars and sort them by price descending, then by
   * artist. You can use visual inspection (sysout) on this one if you're getting tight on time.
   * <p>
   * RESULT:
   */
  @Test
  public void testPriceGreaterThanSortPriceDescThenMusicCategory() {
    // TODO
    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getPrice() > 17.00)
        .sorted(
            comparing(MusicItem::getPrice).reversed()
            .thenComparing(MusicItem::getArtist))
        .collect(Collectors.toList());

    for (MusicItem item : items) {
      System.out.println(item.getPrice());
      System.out.println(item.getArtist());
      System.out.println();
    }

  }

  /**
   * TASK: find all items under 12 dollars released in the 80s and sort them by artist. Hint: To see
   * if an item was released in the 80s, use item.getReleaseDate().toString().startsWith("198")
   * <p>
   * RESULT:
   */
  @Test
  public void testReleaseDateSortArtist() {
    // TODO
    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getPrice() < 12.00)
        .filter(item -> item.getReleaseDate().toString().startsWith("198"))
        .sorted(comparing(MusicItem::getArtist))
        .collect(Collectors.toList());

    System.out.println(items);
    // item.getReleaseDate().toString().startsWith("198")
  }
}
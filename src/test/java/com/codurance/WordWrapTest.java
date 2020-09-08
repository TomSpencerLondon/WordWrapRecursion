package com.codurance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class WordWrapTest {

  private void assertWrap(String text, int w, String expected) {
    assertThat(wrap(text, w), is(expected));
  }


  @Test
  void wraps() {
    assertWrap("", 1, "");
    assertWrap("x", 1, "x");
    assertWrap("xx", 1, "x\nx");
    assertWrap("xxx", 1, "x\nx\nx");
  }

  private String wrap(String text, int n) {
    if (text.length() <= n)
      return text;
    else
      return text.substring(0, n) + "\n" + wrap(text.substring(n), n);
  }
}

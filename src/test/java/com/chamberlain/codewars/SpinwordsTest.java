package com.chamberlain.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chamberlain on 2020/5/21.
 */
public class SpinwordsTest {

    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWordsFunction("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWordsFunction("Hey fellow warriors"));
    }
}

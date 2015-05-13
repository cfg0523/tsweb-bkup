package com.techsen.tsweb.core.util;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AppConfigTest {
    @Test
    public void testGetPorperty() {
        String actual = AppConfig.getProperty("reload");
        assertThat(actual, anyOf(is("true"), is("false")));
    }
}

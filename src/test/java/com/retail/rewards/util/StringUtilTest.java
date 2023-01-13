package com.retail.rewards.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringUtilTest {
    /**
     * Method under test: {@link StringUtil#getMaskedData(String)}
     */
    @Test
    void testGetMaskedData() {
        assertEquals("XXXXXata", StringUtil.getMaskedData("Str Data"));
        assertEquals("", StringUtil.getMaskedData(""));
    }
}


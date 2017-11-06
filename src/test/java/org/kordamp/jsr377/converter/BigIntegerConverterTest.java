/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kordamp.jsr377.converter;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import static org.kordamp.jsr377.formatter.AbstractNumberFormatter.PATTERN_CURRENCY;
import static org.kordamp.jsr377.formatter.AbstractNumberFormatter.PATTERN_PERCENT;

/**
 * @author Andres Almiray
 */
public class BigIntegerConverterTest extends AbstractNumberConverterTestCase<BigInteger> {
    @Override
    protected NumberConverter<BigInteger> createConverter() {
        return new BigIntegerConverter();
    }

    @Override
    protected NumberConverter<BigInteger> createConverter(String format) {
        NumberConverter<BigInteger> converter = createConverter();
        converter.setFormat(format);
        return converter;
    }

    protected Object[] where_value_format_result() {
        return new Object[]{
            new Object[]{null, null, null},
            new Object[]{"", null, null},
            new Object[]{"1", null, BigInteger.ONE},
            new Object[]{"100%", PATTERN_PERCENT, BigInteger.ONE},
            new Object[]{"$1.00", PATTERN_CURRENCY, BigInteger.ONE},
            new Object[]{BigInteger.ONE, null, BigInteger.ONE},
            new Object[]{1L, null, BigInteger.ONE}
        };
    }

    protected Object[] where_invalid_value() {
        return new Object[]{
            new Object[]{"garbage"},
            new Object[]{"1, 2, 3"},
            new Object[]{Collections.emptyList()},
            new Object[]{Collections.emptyMap()},
            new Object[]{Arrays.asList(1, 2, 3)},
            new Object[]{new Object()},
        };
    }
}
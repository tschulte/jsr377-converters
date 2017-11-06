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
package org.kordamp.jsr377.formatter;

import junitparams.Parameters;
import org.junit.Test;
import org.kordamp.jsr377.ConversionSupport;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Andres Almiray
 */
public class LocalTimeFormatterTest extends ConversionSupport {
    @Test
    @Parameters(method = "where_value_literal")
    public void valueProducesLiteral(LocalTime value, String literal) {
        // given:
        LocalTimeFormatter formatter = new LocalTimeFormatter();

        // when:
        String str = formatter.format(value);
        LocalTime result = formatter.parse(str);

        // then:
        assertThat(str, equalTo(literal));
        assertThat(result, equalTo(value));
    }

    protected Object[] where_value_literal() {
        return new Object[]{
            new Object[]{LocalTime.of(1, 2, 3, 101000000), "01:02:03.101"}
        };
    }

    @Test
    @Parameters(method = "where_pattern_value_literal")
    public void valueWithPatternProducesLiteral(String pattern, LocalTime value, String literal) {
        // given:
        LocalTimeFormatter formatter = new LocalTimeFormatter(pattern);

        // when:
        String str = formatter.format(value);
        LocalTime result = formatter.parse(str);

        // then:
        assertThat(str, equalTo(literal));
        assertThat(result, equalTo(value));
    }

    protected Object[] where_pattern_value_literal() {
        return new Object[]{
            new Object[]{"HH mm ss.SSS", null, null},
            new Object[]{"HH mm ss.SSS", LocalTime.of(1, 2, 3, 400000000), "01 02 03.400"}
        };
    }

    @Test(expected = ParseException.class)
    @Parameters(method = "where_parse_error")
    public void parseErrorWithPatternAndLiteral(String pattern, String literal) {
        // given:
        LocalTimeFormatter formatter = new LocalTimeFormatter(pattern);

        // when:
        formatter.parse(literal);
    }

    protected Object[] where_parse_error() {
        return new Object[]{
            new Object[]{"HH mm ss.SSS", "abc"}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "where_invalid_pattern")
    public void createFormatterWithInvalidPattern(String pattern) {
        // expect:
        new LocalTimeFormatter(pattern);
    }

    protected Object[] where_invalid_pattern() {
        return new Object[]{
            new Object[]{";garbage*@%&"},
        };
    }
}

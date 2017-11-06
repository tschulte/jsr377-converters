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

import static org.kordamp.jsr377.formatter.AbstractNumberFormatter.PATTERN_CURRENCY;
import static org.kordamp.jsr377.formatter.AbstractNumberFormatter.PATTERN_PERCENT;

/**
 * @author Andres Almiray
 */
public class LongFormatterTest extends AbstractNumberFormatterTestCase<Long> {
    @Override
    protected Formatter<Long> createFormatter() {
        return new LongFormatter();
    }

    @Override
    protected Formatter<Long> createFormatter(String pattern) {
        return new LongFormatter(pattern);
    }

    protected Object[] where_simple() {
        return new Object[]{
            new Object[]{100L, "100"}
        };
    }

    protected Object[] where_pattern() {
        return new Object[]{
            new Object[]{PATTERN_PERCENT, null, null},
            new Object[]{PATTERN_CURRENCY, 100L, "$100.00"},
            new Object[]{PATTERN_PERCENT, 1L, "100%"},
            new Object[]{null, 100L, "100"},
            new Object[]{"", 100L, "100"},
            new Object[]{"##.0", 20L, "20.0"}
        };
    }

    protected Object[] where_parse_error() {
        return new Object[]{
            new Object[]{PATTERN_CURRENCY, "abc"},
            new Object[]{PATTERN_PERCENT, "abc"}
        };
    }

    protected Object[] where_invalid_pattern() {
        return new Object[]{
            new Object[]{";garbage*@%&"},
        };
    }
}

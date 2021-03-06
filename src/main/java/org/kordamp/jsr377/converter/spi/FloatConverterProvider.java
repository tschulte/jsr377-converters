/*
 * Copyright 2015-2018 the original author or authors.
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
package org.kordamp.jsr377.converter.spi;

import org.kordamp.jsr377.converter.FloatConverter;

import javax.application.converter.Converter;
import javax.application.converter.spi.ConverterProvider;

/**
 * @author Andres Almiray
 */
public class FloatConverterProvider implements ConverterProvider<Float> {
    @Override
    public Class<Float> getTargetType() {
        return Float.class;
    }

    @Override
    public Class<? extends Converter<Float>> getConverterType() {
        return FloatConverter.class;
    }
}

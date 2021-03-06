/*
 * Copyright (c) 2016 by Gerrit Grunwald
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

package eu.hansolo.fx.fitnessgauge;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

import java.util.HashMap;


/**
 * Created by hansolo on 07.04.16.
 */
public class FitnessGaugeBuilder<B extends FitnessGaugeBuilder<B>> {
    private HashMap<String, Property> properties = new HashMap<>();


    // ******************** Constructors **************************************
    protected FitnessGaugeBuilder() {}


    // ******************** Methods *******************************************
    public static final FitnessGaugeBuilder create() {
        return new FitnessGaugeBuilder();
    }

    public final B outerMaxValue(final double VALUE) {
        properties.put("outerMaxValue", new SimpleDoubleProperty(VALUE));
        return (B)this;
    }

    public final B middleMaxValue(final double VALUE) {
        properties.put("middleMaxValue", new SimpleDoubleProperty(VALUE));
        return (B)this;
    }

    public final B innerMaxValue(final double VALUE) {
        properties.put("innerMaxValue", new SimpleDoubleProperty(VALUE));
        return (B)this;
    }

    public final B outerText(final String TEXT) {
        properties.put("outerText", new SimpleStringProperty(TEXT));
        return (B)this;
    }

    public final B middleText(final String TEXT) {
        properties.put("middleText", new SimpleStringProperty(TEXT));
        return (B)this;
    }

    public final B innerText(final String TEXT) {
        properties.put("innerText", new SimpleStringProperty(TEXT));
        return (B)this;
    }

    public final B outerTextVisible(final boolean VISIBLE) {
        properties.put("outerTextVisible", new SimpleBooleanProperty(VISIBLE));
        return (B)this;
    }

    public final B middleTextVisible(final boolean VISIBLE) {
        properties.put("middleTextVisible", new SimpleBooleanProperty(VISIBLE));
        return (B)this;
    }

    public final B innerTextVisible(final boolean VISIBLE) {
        properties.put("innerTextVisible", new SimpleBooleanProperty(VISIBLE));
        return (B)this;
    }

    public final B outerValue(final double VALUE) {
        properties.put("outerValue", new SimpleDoubleProperty(VALUE));
        return (B)this;
    }

    public final B middleValue(final double VALUE) {
        properties.put("middleValue", new SimpleDoubleProperty(VALUE));
        return (B)this;
    }

    public final B innerValue(final double VALUE) {
        properties.put("innerValue", new SimpleDoubleProperty(VALUE));
        return (B)this;
    }

    public final B outerColor(final Color COLOR) {
        properties.put("outerColor", new SimpleObjectProperty<>(COLOR));
        return (B)this;
    }

    public final B middleColor(final Color COLOR) {
        properties.put("middleColor", new SimpleObjectProperty<>(COLOR));
        return (B)this;
    }

    public final B innerColor(final Color COLOR) {
        properties.put("innerColor", new SimpleObjectProperty<>(COLOR));
        return (B)this;
    }

    public final B prefSize(final double WIDTH, final double HEIGHT) {
        properties.put("prefSize", new SimpleObjectProperty<>(new Dimension2D(WIDTH, HEIGHT)));
        return (B)this;
    }
    public final B minSize(final double WIDTH, final double HEIGHT) {
        properties.put("minSize", new SimpleObjectProperty<>(new Dimension2D(WIDTH, HEIGHT)));
        return (B)this;
    }
    public final B maxSize(final double WIDTH, final double HEIGHT) {
        properties.put("maxSize", new SimpleObjectProperty<>(new Dimension2D(WIDTH, HEIGHT)));
        return (B)this;
    }

    public final B prefWidth(final double PREF_WIDTH) {
        properties.put("prefWidth", new SimpleDoubleProperty(PREF_WIDTH));
        return (B)this;
    }
    public final B prefHeight(final double PREF_HEIGHT) {
        properties.put("prefHeight", new SimpleDoubleProperty(PREF_HEIGHT));
        return (B)this;
    }

    public final B minWidth(final double MIN_WIDTH) {
        properties.put("minWidth", new SimpleDoubleProperty(MIN_WIDTH));
        return (B)this;
    }
    public final B minHeight(final double MIN_HEIGHT) {
        properties.put("minHeight", new SimpleDoubleProperty(MIN_HEIGHT));
        return (B)this;
    }

    public final B maxWidth(final double MAX_WIDTH) {
        properties.put("maxWidth", new SimpleDoubleProperty(MAX_WIDTH));
        return (B)this;
    }
    public final B maxHeight(final double MAX_HEIGHT) {
        properties.put("maxHeight", new SimpleDoubleProperty(MAX_HEIGHT));
        return (B)this;
    }

    public final B scaleX(final double SCALE_X) {
        properties.put("scaleX", new SimpleDoubleProperty(SCALE_X));
        return (B)this;
    }
    public final B scaleY(final double SCALE_Y) {
        properties.put("scaleY", new SimpleDoubleProperty(SCALE_Y));
        return (B)this;
    }

    public final B layoutX(final double LAYOUT_X) {
        properties.put("layoutX", new SimpleDoubleProperty(LAYOUT_X));
        return (B)this;
    }
    public final B layoutY(final double LAYOUT_Y) {
        properties.put("layoutY", new SimpleDoubleProperty(LAYOUT_Y));
        return (B)this;
    }

    public final B translateX(final double TRANSLATE_X) {
        properties.put("translateX", new SimpleDoubleProperty(TRANSLATE_X));
        return (B)this;
    }
    public final B translateY(final double TRANSLATE_Y) {
        properties.put("translateY", new SimpleDoubleProperty(TRANSLATE_Y));
        return (B)this;
    }

    public final B padding(final Insets INSETS) {
        properties.put("padding", new SimpleObjectProperty<>(INSETS));
        return (B)this;
    }

    public final FitnessGauge build() {
        final FitnessGauge CONTROL = new FitnessGauge();
        for (String key : properties.keySet()) {
            if ("prefSize".equals(key)) {
                Dimension2D dim = ((ObjectProperty<Dimension2D>) properties.get(key)).get();
                CONTROL.setPrefSize(dim.getWidth(), dim.getHeight());
            } else if("minSize".equals(key)) {
                Dimension2D dim = ((ObjectProperty<Dimension2D>) properties.get(key)).get();
                CONTROL.setMinSize(dim.getWidth(), dim.getHeight());
            } else if("maxSize".equals(key)) {
                Dimension2D dim = ((ObjectProperty<Dimension2D>) properties.get(key)).get();
                CONTROL.setMaxSize(dim.getWidth(), dim.getHeight());
            } else if("prefWidth".equals(key)) {
                CONTROL.setPrefWidth(((DoubleProperty) properties.get(key)).get());
            } else if("prefHeight".equals(key)) {
                CONTROL.setPrefHeight(((DoubleProperty) properties.get(key)).get());
            } else if("minWidth".equals(key)) {
                CONTROL.setMinWidth(((DoubleProperty) properties.get(key)).get());
            } else if("minHeight".equals(key)) {
                CONTROL.setMinHeight(((DoubleProperty) properties.get(key)).get());
            } else if("maxWidth".equals(key)) {
                CONTROL.setMaxWidth(((DoubleProperty) properties.get(key)).get());
            } else if("maxHeight".equals(key)) {
                CONTROL.setMaxHeight(((DoubleProperty) properties.get(key)).get());
            } else if("scaleX".equals(key)) {
                CONTROL.setScaleX(((DoubleProperty) properties.get(key)).get());
            } else if("scaleY".equals(key)) {
                CONTROL.setScaleY(((DoubleProperty) properties.get(key)).get());
            } else if ("layoutX".equals(key)) {
                CONTROL.setLayoutX(((DoubleProperty) properties.get(key)).get());
            } else if ("layoutY".equals(key)) {
                CONTROL.setLayoutY(((DoubleProperty) properties.get(key)).get());
            } else if ("translateX".equals(key)) {
                CONTROL.setTranslateX(((DoubleProperty) properties.get(key)).get());
            } else if ("translateY".equals(key)) {
                CONTROL.setTranslateY(((DoubleProperty) properties.get(key)).get());
            } else if ("padding".equals(key)) {
                CONTROL.setPadding(((ObjectProperty<Insets>) properties.get(key)).get());
            } else if ("outerMaxValue".equals(key)) {
                CONTROL.setOuterMaxValue(((DoubleProperty) properties.get(key)).get());
            } else if("middleMaxValue".equals(key)) {
                CONTROL.setMiddleMaxValue(((DoubleProperty) properties.get(key)).get());
            } else if("innerMaxValue".equals(key)) {
                CONTROL.setInnerMaxValue(((DoubleProperty) properties.get(key)).get());
            } else if("outerText".equals(key)) {
                CONTROL.setOuterText(((StringProperty) properties.get(key)).get());
            } else if("middleText".equals(key)) {
                CONTROL.setMiddleText(((StringProperty) properties.get(key)).get());
            } else if("innerText".equals(key)) {
                CONTROL.setInnerText(((StringProperty) properties.get(key)).get());
            } else if ("outerTextVisible".equals(key)) {
                CONTROL.setOuterTextVisible(((BooleanProperty) properties.get(key)).get());
            } else if ("middleTextVisible".equals(key)) {
                CONTROL.setMiddleTextVisible(((BooleanProperty) properties.get(key)).get());
            } else if ("innerTextVisible".equals(key)) {
                CONTROL.setInnerTextVisible(((BooleanProperty) properties.get(key)).get());
            } else if ("outerValue".equals(key)) {
                CONTROL.setOuterValue(((DoubleProperty) properties.get(key)).get());
            } else if ("middleValue".equals(key)) {
                CONTROL.setMiddleValue(((DoubleProperty) properties.get(key)).get());
            } else if ("innerValue".equals(key)) {
                CONTROL.setInnerValue(((DoubleProperty) properties.get(key)).get());
            } else if ("outerColor".equals(key)) {
                CONTROL.setOuterColor(((ObjectProperty<Color>) properties.get(key)).get());
            } else if ("middleColor".equals(key)) {
                CONTROL.setMiddleColor(((ObjectProperty<Color>) properties.get(key)).get());
            } else if ("innerColor".equals(key)) {
                CONTROL.setInnerColor(((ObjectProperty<Color>) properties.get(key)).get());
            }
        }
        return CONTROL;
    }
}

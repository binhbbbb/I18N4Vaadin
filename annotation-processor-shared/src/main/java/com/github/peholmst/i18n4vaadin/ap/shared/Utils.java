/*
 * Copyright (c) 2012 Petter Holmström
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.peholmst.i18n4vaadin.ap.shared;

import com.github.peholmst.i18n4vaadin.annotations.Locale;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/**
 * Class containing different utility methods. <p><b>This class is internal and
 * should never be used by clients.</b>
 *
 * @author Petter Holmström
 */
final class Utils {

    private Utils() {
    }

    static boolean stringToBoolean(String str) {
        if (str == null) {
            return false;
        } else {
            return Boolean.parseBoolean(str);
        }
    }

    static PackageElement getPackage(final Element element) {
        if (element == null) {
            return null;
        } else if (element.getKind() == ElementKind.PACKAGE) {
            return (PackageElement) element;
        } else if (element.getEnclosingElement().getKind() == ElementKind.PACKAGE) {
            return (PackageElement) element.getEnclosingElement();
        } else {
            return getPackage(element.getEnclosingElement());
        }
    }
    
    static TypeElement getType(final Element element) {
        if (element == null) {
            return null;
        } else if (element.getKind() == ElementKind.CLASS || element.getKind() == ElementKind.INTERFACE || element.getKind() == ElementKind.ENUM || element.getKind() == ElementKind.ANNOTATION_TYPE) {
            return (TypeElement) element;
        } else {
            return getType(element.getEnclosingElement());
        }
    }

    /*
    static boolean hasParentPackage(String packageName) {
        return packageName.contains(".");
    }

    static String getParentPackage(String packageName) {
        final int endIndex = packageName.lastIndexOf(".");
        if (endIndex == -1) {
            return "";
        } else {
            return packageName.substring(0, endIndex);
        }
    }
*/
    static java.util.Locale convertLocaleAnnotation(Locale annotation) {
        if (annotation.language().isEmpty()) {
            return null;
        } else {
            return new java.util.Locale(annotation.language(), annotation.country(), annotation.variant());
        }
    }
}

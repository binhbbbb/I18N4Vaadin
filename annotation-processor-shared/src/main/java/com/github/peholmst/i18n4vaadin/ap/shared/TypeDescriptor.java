/*
 * Copyright (c) 2012, 2013 Petter Holmström
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

import javax.lang.model.element.TypeElement;

/**
 *
 * @author Petter Holmström
 */
public class TypeDescriptor extends MessageOwner {

    private final TypeElement element;
    private PackageDescriptor pkg;

    TypeDescriptor(TypeElement element) {
        this.element = element;
    }

    public PackageDescriptor getPackage() {
        return pkg;
    }

    void setPackage(PackageDescriptor pkg) {
        this.pkg = pkg;
    }

    public TypeElement getElement() {
        return element;
    }

    public String getQualifiedName() {
        return element.getQualifiedName().toString();
    }

    public String getSimpleName() {
        return element.getSimpleName().toString();
    }
}

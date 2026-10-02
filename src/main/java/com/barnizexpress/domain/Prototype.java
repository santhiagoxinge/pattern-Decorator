package com.barnizexpress.domain;

/** Creates an independent copy of an object that can serve as a prototype. */
public interface Prototype<T> {

    T copy();
}

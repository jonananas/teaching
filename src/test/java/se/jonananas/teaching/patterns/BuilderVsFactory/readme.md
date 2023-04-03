# Builder vs Factory

## Static Factory Method

Static Factory Method is **not** Factory, Factory method or Abstract Factory.

### When

Creation is a bit complex for constructor
or you want to distinguish and describe different creation methods. 

## Then

Create a static method that returns an instance of a class.

*“Static factory method is simply a static method that returns an instance of a class”* Effective Java by Joshua Bloch

## Builder

### When

Creation is a bit complex for constructor, and even static factory method; many input parameters and/or several optionals leading to multiple constructors.

### Then

Create a fluent interface Builder that takes each parameter one by one and then returns an instance of a class in a single step.

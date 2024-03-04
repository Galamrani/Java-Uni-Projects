## Description
This repository contains the implementation of a generic `AssociationTable` class in Java. An `AssociationTable` maps keys of type `E` to values of type `T`. It provides functionalities like adding key-value pairs, retrieving values by keys, checking for key existence, removing key-value pairs, and obtaining the size of the table.

## Files

1. **App.java**: Contains the `main` method to demonstrate the usage of the `AssociationTable` class. It showcases adding, updating, and removing entries from the table.

2. **AssociationTable.java**: Implements the `AssociationTable` class, which is a generic class with functionalities to manage key-value pairs. It uses a `TreeMap` internally for efficient key-value storage and retrieval.

3. **IllegalArgumentException.java**: Custom exception class to handle illegal arguments when initializing the association table.

4. **Student.java**: Represents a simple `Student` class with attributes such as first name, last name, student ID, and year of birth. It implements the `Comparable` interface to enable sorting of student objects based on their IDs.

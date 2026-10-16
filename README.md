
# Apartment Hunting Tracker 🏠

## About the Project

Apartment Hunting Tracker is a Java-based program designed to help students organize, compare, and evaluate potential rental properties.

The objective of this program is to **identify rental properties that best match a student's housing needs** based on monthly rent, distance to campus, number of bedrooms, availability, and additional amenities.

The program uses object-oriented programming to represent different property types and a custom scoring system to determine the most suitable rental options.

## How It Works

The program organizes rental properties into three categories: Apartments, Condos, and Basement Units.

Each property contains basic information such as its address, monthly rent, number of bedrooms, distance to campus, and availability.

The program uses a `Property` superclass to store shared information, while three subclasses represent the different rental types and their unique features.

For each property, the program:

1. Stores the property's information and additional amenities.
2. Adds the property to an `ArrayList<Property>`.
3. Checks availability and affordability.
4. Calculates a match score based on rental criteria.
5. Adjusts the score according to property-specific features.
6. Compares and sorts properties to identify the best options.

The program demonstrates these operations using sample rental listings and displays the results in the console.

## Features

The program allows users to:

- Add and remove rental listings
- View all properties or only available listings
- Search for properties within a specified budget
- Identify the cheapest rental property
- Calculate and compare property match scores
- Find the best overall rental match
- Sort properties by their match scores
- Update property availability

### Property Types

Each property type includes additional features and methods:

- **Apartment** - Tracks floor number and laundry availability, with a method to evaluate convenience.
- **Condo** - Tracks monthly condo fees, gym access, and security, with a method to calculate total monthly housing costs.
- **BasementUnit** - Tracks furnishing and separate entrance availability, with a method to identify suitable budget options.

## Property Matching Algorithm

The program uses a **custom scoring algorithm** to compare rental properties.

Each property starts with a base score of `100`, which is adjusted based on:

- **Monthly Rent** - Higher rent reduces the score.
- **Bedrooms** - Additional bedrooms increase the score.
- **Distance to Campus** - Greater distance reduces the score.
- **Availability** - Unavailable properties receive a 40-point penalty.
- **Amenities** - Property-specific features increase or decrease the score.

The base score is calculated using:

`Score = 100 - (Monthly Rent / 50) + (Bedrooms × 12) - (Distance × 5)`

Additional adjustments are applied depending on the property type:

- **Apartment** - Rewards laundry access (+12) and penalizes floors above five (-5).
- **Condo** - Rewards gym access (+8) and security (+6), while deducting points for condo fees (fee / 25).
- **BasementUnit** - Rewards furnishing (+7) and a separate entrance (+10).

Properties are compared using their final match scores, with higher scores representing better matches.

## Data Structures Used

The program uses several data structures and data types, including:

- **ArrayList (`ArrayList<Property>`)** - Stores rental listings in a dynamically sized collection, allowing properties to be added, removed, searched, and sorted.
- **Objects** - Represent individual apartments, condos, and basement units with their own attributes and methods.
- **Strings (`String`)** - Store property addresses and tracker names.
- **Doubles (`double`)** - Store rental prices, distances, condo fees, and match scores.
- **Integers (`int`)** - Store bedroom counts and floor numbers.
- **Booleans (`boolean`)** - Track availability and property amenities.

The primary data structure is the `ArrayList<Property>`, which allows different property subclasses to be stored and managed together.

## Searching and Sorting

The program includes several methods for organizing rental properties:

- **`findCheapestListing()`** - Iterates through the listings to find the property with the lowest monthly rent.
- **`searchByMaxRent()`** - Filters properties based on a specified maximum rental budget.
- **`getBestMatch()`** - Compares property match scores and returns the highest-scoring property.
- **`sortListings()`** - Uses `Collections.sort()` and the `Comparable<Property>` interface to sort properties from highest to lowest match score.

## Project Files

- `Property.java` - Superclass containing shared property information, scoring, and comparison methods.
- `Apartment.java` - Apartment subclass with floor and laundry features.
- `Condo.java` - Condo subclass with condo fees and additional amenities.
- `BasementUnit.java` - Basement unit subclass with furnishing and entrance features.
- `ApartmentTracker.java` - Manages rental listings, searching, filtering, and sorting.
- `ProjectOneTester.java` - Contains the `main()` method and tests the program's functionality.
- `README.md` - Project documentation.

## Running the Program

1. Make sure JDK 21 or newer is installed.
2. Place all six Java files in the same project directory.
3. Open the project in a Java-compatible IDE.
4. Run the `main()` method in `ProjectOneTester.java`.
5. View the property listings, comparisons, and sorting results in the console.

The sample properties and rental criteria can be modified in `ProjectOneTester.java` to test different scenarios.

## Java Concepts Used

This project demonstrates several Java programming concepts, including:

- **Object-Oriented Programming** - Organizing functionality into classes and objects.
- **Inheritance** - Using a superclass and subclasses to share property information.
- **Polymorphism** - Managing different property types through shared methods and references.
- **Encapsulation** - Using private fields with public getters and setters.
- **Constructor Overloading** - Providing multiple ways to initialize property objects.
- **Method Overriding** - Customizing scoring and display methods for different property types.
- **Interfaces** - Implementing `Comparable<Property>` to compare and sort objects.
- **Generics and ArrayLists** - Storing and managing property objects in collections.
- **Searching and Sorting** - Filtering properties and sorting them using `Collections.sort()`.
- **Enhanced For Loops** - Iterating through rental listings.
- **Conditional Statements** - Evaluating affordability, availability, and amenities.
- **Boolean Logic** - Checking whether properties meet specific criteria.
- **The `super` and `this` Keywords** - Accessing inherited functionality and initializing objects.
- **The `equals()` and `toString()` Methods** - Comparing properties and generating readable descriptions.

## Purpose

The purpose of this project is to demonstrate how **object-oriented programming, data structures, inheritance, polymorphism, and searching and sorting algorithms** can be used to create a practical rental property tracking system.

By combining specialized property classes, an ArrayList-based tracker, and a custom matching algorithm, the program demonstrates how Java can organize and evaluate real-world information to help identify suitable rental properties.

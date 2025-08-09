//Record is a replacement of POJO entire code into a single line code
//Java JVM internally generates the necessary getter methods, constructors and instance fields.
//Record doesn't have or support setter methods
//Record has instance fields which are private and final.
//Record parameters are called record components and can be accessed using accessors methods.
//Example: id(), firstName() are accessor methods for record.

public record UsageOfRecordInsteadOfPOJOClass(int id, String firstName, String lastName, String surName) {
}

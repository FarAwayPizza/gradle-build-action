Similarities between Aggregation Pipelines and SQL Queries:

- **Data Grouping**: Both SQL and MongoDB use grouping to process records. In SQL, `GROUP BY` allows grouping by specific columns, while MongoDB's aggregation uses the `$group` stage to group documents by fields.
- **Filtering**: SQL uses `WHERE` to filter data, whereas MongoDB uses the `$match` stage in its aggregation pipeline.
- **Sorting**: Both use sorting. SQL uses `ORDER BY`, while MongoDB uses the `$sort` stage.
- **Calculations and Functions**: In SQL, we use aggregate functions such as `COUNT()`, `SUM()`, `AVG()`, etc., to calculate values. Similarly, MongoDB has operators like `$sum`, `$avg`, and `$count` that serve the same purpose within the aggregation pipeline.
- **Join-like Operations**: SQL supports joins, and MongoDB can achieve similar functionality using `$lookup` to combine documents from different collections.

### User-Friendliness:

- **SQL**: SQL is declarative, meaning that SQL queries can feel more natural. Especially for simple tasks such as filtering, grouping, and sorting. The high-level abstraction  makes it easy to read and write queries.
- **MongoDB**: Aggregation pipelines are also straightforward but require a bit more setup. MongoDB is more flexible, especially for nested and complex operations.

### Efficiency:

- **SQL**: SQL engines are  highly optimised for relational data. They are efficient when working with structured data. However, when dealing with large amounts of unstructured  data, relational databases can become inefficient because of the rigid schema.
- **MongoDB**: MongoDB excels with flexible schema design and can efficiently handle complex, nested data structures.

### Abstraction Levels:

- **SQL**: Provides a high level of abstraction, which can be advantageous for straightforward queries but limiting for complex transformations.

- **MongoDB**: Offers a lower level of abstraction with its pipeline structure, allowing for more control over data transformation and processing. This is beneficial when working with complex documents and JSON-like structures.


### Imperative vs. Declarative:

- **SQL**: Is a declarative language, meaning you specify what you want, and the system determines how to do it. This makes SQL easier to understand for simple queries.

- **MongoDB**: The aggregation pipeline is more imperative, as you describe each step of the operation explicitly, which gives more control but requires more detailed instructions for each step.

### Distributed System Concepts (Partitioning/Sharding):

- **SQL**: Most traditional SQL databases are designed for vertical scaling (scaling by increasing resources of a single machine). Partitioning and sharding are supported in some SQL databases but usually require additional configurations.

- **MongoDB**: MongoDB is designed to scale horizontally, which is done through sharding. Aggregation pipelines can process data across shards, making MongoDB a better fit for distributed databases.

### Conclusion:

- **User Friendliness**: For simple queries, SQL is more user-friendly due to its high-level abstraction and straightforward syntax. However, MongoDB's aggregation pipelines provide more flexibility and power when dealing with complex or nested data structures.
- **Efficiency**: MongoDB tends to be more efficient when handling large, distributed, and flexible datasets due to its native support for horizontal scaling and document-based architecture. SQL, on the other hand, shines in handling structured data in relational models, especially with mature optimisations in traditional RDBMSs.


---

# DAT250 - MongoDB Assignment Report

## 1. Technical Problems Encountered During Installation and Use of MongoDB

**Problem 1: Version Compatibility Issue**

- **Description**: During the installation of MongoDB 4.4 Community Edition, there was an issue with the compatibility of the operating system. MongoDB required an updated version of certain libraries, which were missing on the system.
- **Resolution**: I upgraded the required libraries.

## 2. Screenshots for Validation and Experiment Results

###  CRUD Operations - Experiment 1

**Insert Operation**

- Successfully inserted new documents into the `inventory` collection using the `insertMany()` method. _Include screenshot showing a successful insert operation._



![[Screenshot 2024-10-07 at 19.23.33.png]]

**Query Operation**

- Retrieved documents from the `inventory` collection using the `find()` method to filter by certain criteria. _Include screenshot of the query operation._
  ![[Screenshot 2024-10-07 at 19.24.06.png]]


**Update Operation**

- Used the `updateOne()` method to modify specific fields in the documents, such as changing the quantity of items. _Include screenshot showing an update operation._
  ![[Screenshot 2024-10-07 at 19.24.23.png]]

**Delete Operation**

- Performed deletion of specific documents from the `inventory` collection using `deleteMany()` to remove items with certain criteria. _Include screenshot of the delete operation._
  ![[Screenshot 2024-10-07 at 19.25.48.png]]
### c) Aggregation Operations - Experiment 2

In Experiment 2, I worked with the aggregation pipeline to group documents and calculate values. One such operation involved summing populations for specific states from the `zipcode_data` collection. The final output listed the total population per state.


![[Screenshot 2024-10-07 at 19.26.22.png]]


## 3. Reasoning on the Map-Reduce Operation

The map-reduce operation was useful in breaking down large data sets into smaller, more manageable components for processing. It provided a way to calculate aggregates while maintaining flexibility in applying more complex operations like calculating averages or percentages. This method was particularly useful for distributed systems where partitioning and sharding are required, allowing for more efficient data processing across multiple servers.

## 4. Pending Issues

- **Bulk Write Errors**: While working on bulk write operations, I encountered duplicate key errors due to conflicts with existing document `_id` values. These errors were not resolved within the current scope of the experiment, but would require adjusting or generating unique identifiers in future runs.

---
## Pending issues

#### Validation of the installation package

Can't seem to find out were I installed the packages. And I wan't to start on the next task since i'm already behind. Can show this some other time if needed.


# CSE3146 – Advanced Java Programming

**Presidency University | Department of Computer Science & Engineering**

This repository contains all lab programs for the course **CSE3146 – Advanced Java Programming**, organized by module. The course covers Multithreading, Input/Output Operations, and Java Database Connectivity (JDBC).

---

## 📁 Repository Structure

```
CSE3146-Advanced-Java-Programming/
├── Module-1_Multithreading/
│   ├── Q1_RunnableThread/         → Single thread using Runnable interface
│   ├── Q2_ExtendThread/           → Single thread by extending Thread class
│   ├── Q3_MultipleThreads/        → 3 threads printing 5 to 1 concurrently
│   ├── Q4_FactorialThreads/       → 3 threads for factorial with join/isAlive
│   ├── Q5_ThreadPriority/         → Thread priority demonstration
│   └── Q6_Synchronization/        → Thread synchronization to avoid race condition
├── Module-2_IO-Operations/
│   ├── Q1_TextFileOperations/     → Create, write, read, copy text files
│   ├── Q2_FileStats/              → Word/character/sentence count with line numbers
│   ├── Q3_BinaryFileOperations/   → Create, write, read binary (.dat) files
│   ├── Q4_FileChannelBuffer/      → Read/write using FileChannel and ByteBuffer
│   └── Q5_Serialization/          → Serialize and deserialize a Student object
└── Module-3_JDBC/
    ├── Q1_JDBCOverview/           → JDBC interfaces and classes reference
    ├── Q2_MySQLSetup/             → SQL scripts to create userDB and user table
    ├── Q3a_Insert/                → JDBC Insert operation
    ├── Q3b_Update/                → JDBC Update operation
    ├── Q3c_Delete/                → JDBC Delete operation
    └── Q3d_Select/                → JDBC Select operation
```

---

## 📚 Modules Overview

### Module 1 – Multithreading
Covers creating threads via `Runnable` interface and `Thread` class extension, managing multiple concurrent threads, using `sleep()`, `join()`, `isAlive()`, thread priorities, and synchronization.

### Module 2 – Input/Output Operations
Covers text and binary file operations using `FileWriter`, `FileReader`, `BufferedReader`, `FileOutputStream`, `FileInputStream`, `FileChannel`, `ByteBuffer`, and Java Serialization.

### Module 3 – Java Database Connectivity (JDBC)
Covers connecting to MySQL using JDBC, and performing all CRUD operations (INSERT, UPDATE, DELETE, SELECT) using `Statement` and `PreparedStatement`.

> ⚠️ **Midterm Hint from Instructor:** Part A has 5 questions (5 marks each). Part B (25 marks) will be an execution-based question from **JDBC**. Prepare well!

---

## 🛠️ Prerequisites

- Java JDK 8 or above
- MySQL Server (for Module 3)
- MySQL JDBC Connector JAR (`mysql-connector-java`)
- Any IDE: IntelliJ IDEA, Eclipse, or online compiler like [JDoodle](https://www.jdoodle.com/online-javacompiler/)

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/presidencyflash/CSE3146-Advanced-Java-Programming.git
   ```
2. Navigate to the desired module folder.
3. Compile and run:
   ```bash
   javac FileName.java
   java FileName
   ```
4. For JDBC programs, ensure MySQL is running and add the connector JAR to classpath:
   ```bash
   javac -cp .;mysql-connector-java.jar FileName.java
   java -cp .;mysql-connector-java.jar FileName
   ```

---

## 📝 Course Details

| Field | Info |
|-------|------|
| Course Code | CSE3146 |
| Course Name | Advanced Java Programming |
| Institution | Presidency University, Bangalore |
| Department | Computer Science & Engineering |

---

*Maintained for academic reference and midterm preparation.*

\#  Expense Tracker (Java Console Application)



\##  Overview



The \*\*Expense Tracker\*\* is a console-based Java application designed to help users efficiently manage their daily expenses.

It allows users to record, store, retrieve, and analyze expenses with persistent storage using file handling.



This project demonstrates the practical implementation of core Java concepts such as Object-Oriented Programming (OOP), Collections, File Handling, and Command Line Arguments.



\---



\##  Objectives



\* To develop a simple and efficient expense management system

\* To apply Java programming concepts in a real-world scenario

\* To implement file handling for data persistence

\* To demonstrate command line argument usage



\---



\##  Key Features



\*  Add new expense records

\*  View all saved expenses

\*  Calculate total expenditure

\*  Search expenses by category (case-insensitive)

\*  Automatic data saving using file handling

\*  Run-time file selection using command line arguments



\---



\##  Technologies \& Concepts Used



\* \*\*Java (Core Java)\*\*

\* \*\*Object-Oriented Programming (OOP)\*\*

\* \*\*Collections Framework (ArrayList)\*\*

\* \*\*File Handling\*\*



&#x20; \* FileReader

&#x20; \* FileWriter

&#x20; \* BufferedReader

\* \*\*Command Line Arguments\*\*



\---



\##  Project Structure



```id="rz2rxb"

ExpenseTracker.java   → Main application logic

Expense.class         → Compiled Expense class

ExpenseTracker.class  → Compiled main class

data.txt              → Stored expense data

```



\---



\##  How to Run the Project



\###  Step 1: Compile



```id="j5b8l9"

javac ExpenseTracker.java

```



\###  Step 2: Execute



```id="u7k61h"

java ExpenseTracker data.txt

```



>  Note: `data.txt` is the file where all expenses will be stored.







\##  Sample Execution



\### Input:



```id="r1nj80"

1

500

Food

29-03-2026

Lunch

```



\### Output:



```id="pt3v8h"

Amount: 500 | Category: Food | Date: 29-03-2026 | Desc: Lunch

```







\##  Data Persistence



\* All expense data is stored in a text file (`data.txt`)

\* Data is automatically loaded when the program starts

\* Ensures information is retained across multiple runs





\##  Functional Flow



1\. Program starts and loads existing data

2\. Menu is displayed to the user

3\. User selects an operation:



&#x20;  \* Add Expense

&#x20;  \* View Expenses

&#x20;  \* Calculate Total

&#x20;  \* Search by Category

4\. Data is updated and saved to file

5\. Program exits on user command







\##  Future Enhancements



\* Graphical User Interface (GUI) using Swing/JavaFX

\* Monthly and yearly expense reports

\* Sorting expenses by date or amount

\* Category-wise summaries and charts

\* Database integration (MySQL)



\---



\##  Learning Outcomes



\* Understanding of file handling and persistent storage

\* Practical implementation of OOP concepts

\* Experience with command line execution

\* Development of a real-world problem-solving application







\##  Author



\*\*Riya Shukla\*\*







\##  Conclusion



This project successfully demonstrates how Java can be used to build a functional and efficient expense management system. It highlights the importance of structured programming and data persistence in real-world applications.




# Design Document: Decision Engine

## Project Track

**Option D: The Decision Engine**

For this project, I selected a **loan application decision engine** as the application domain. The goal is to design and implement a Java program that can automatically classify a loan applicant as either **Approved** or **Rejected** based on financial attributes such as income, credit score, debt-to-income ratio, and employment history.

## Problem Overview

Loan approval is a decision-heavy process that requires evaluating multiple applicant attributes in a consistent order. A decision engine can help automate this process by applying a structured set of rules. For example, an applicant with a strong credit score, stable income, and reasonable debt-to-income ratio may be approved, while an applicant with poor credit or insufficient income may be rejected.

The system should be able to take in applicant information, evaluate it against predefined rules, and return a final classification. This makes the problem a good fit for tree-based logic because each decision can lead to another condition or a final result.

## Proposed Design

The main structure for the decision process will be a **Decision Tree**. Each internal node will represent a rule or condition, such as checking whether the applicant’s credit score is above a certain threshold. Each branch will represent the outcome of that condition, and each leaf node will represent a final classification of either **Approved** or **Rejected**.

A **Binary Search Tree** may also be useful for organizing applicant records by a searchable key, such as applicant ID, credit score, or income. This would allow the program to efficiently insert, search, and retrieve applicant data before or after classification.

The overall design separates two major responsibilities:

1. Storing and retrieving applicant records efficiently.
2. Evaluating applicant records through a structured decision process.

This separation keeps the program organized and makes the decision logic easier to modify if the approval rules change later.

## Big-O Expectations

For the applicant storage portion, a balanced Binary Search Tree would allow search, insertion, and deletion operations to run in **O(log n)** time, where `n` is the number of applicant records. This is efficient because each comparison reduces the remaining search space by about half. However, if the tree becomes unbalanced, the worst-case time complexity could degrade to **O(n)**.

For the decision-making portion, classifying an applicant using a Decision Tree should take **O(h)** time, where `h` is the height of the tree. The program only follows one path from the root to a leaf, so it does not need to check every possible rule. If the decision tree is shallow and well-organized, classification should be fast. In the worst case, if the tree is very deep, classification could approach **O(n)**, where `n` is the number of decision nodes.

Overall, the expected performance is efficient for this project because applicant lookup can be handled logarithmically in a balanced tree, while classification only requires traversing a single path through the decision logic.

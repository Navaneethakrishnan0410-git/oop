#  AlgorithmToolkit

A compact Java-based toolkit that implements core algorithmic utilities including sorting, searching, data structures (stack and queue), and performance benchmarking. Ideal for students, educators, and developers looking to understand and experiment with fundamental algorithms.

---

## 📁 Project Structure
com/
└── AlgorithmToolKit/
├── AlgorithmToolkit.java       # Main class with test cases
├── SortingUtil.java           # Bubble, Insertion, Merge, Quick Sort
├── SearchUtil.java            # Linear and Binary Search
├── CollectionUtil.java        # Custom Stack and Queue implementations
└── AnalysisUtil.java          # Timing and benchmarking utilities


---

## 🚀 Features

### 🔢 Sorting Algorithms
- Bubble Sort
- Insertion Sort
- Merge Sort
- Quick Sort

### 🔍 Searching Algorithms
- Linear Search
- Binary Search (requires sorted input)

### 📦 Data Structures
- Stack (LIFO) – implemented using a singly linked list
- Queue (FIFO) – implemented using a singly linked list

### ⏱️ Performance Analysis
- `timeMillis(Runnable task)` – Measures execution time in milliseconds
- `benchmarkMillis(Runnable task, int iterations)` – Averages execution time over multiple runs

---




## 🛠️ How to Run

1. Clone the repository or copy the source files.
2. Compile the project:
   ```bash
   javac com/AlgorithmToolKit/AlgorithmToolkit.java
   java com.AlgorithmToolKit.AlgorithmToolkit
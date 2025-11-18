# ⚙️ MultiThreaded Log Analyzer (Java)

This project is a Java-based multithreaded application that scans `.txt` log files in a given folder and counts the occurrences of specific keywords like `error`, `warning`, `failed`, and `success`. It compares the performance of concurrent vs sequential processing and writes the final summary to an output file.

---

## 🚀 Features

- ✅ Multithreaded log file processing using `ExecutorService`
- ✅ Keyword frequency analysis across multiple files
- ✅ Performance comparison: concurrent vs sequential execution
- ✅ Output saved to `log_result.txt`
- ✅ Thread-safe global aggregation using `ConcurrentHashMap`

---

## 🔍 Keywords Tracked

- `error`
- `warning`
- `failed`
- `success`

---

## 📂 Project Structure
com/ 
└── Logs/ 
└── Logss/ 
└── MultiThreadDemo.java

---

## 🧑‍💻 How to Run

1. **Compile the program**:
   ```bash
   javac com/Logs/Logss/MultiThreadDemo.java
   java com.Logs.Logss.MultiThreadDemo
   java com.Logs.Logss.MultiThreadDemo /path/to/logs
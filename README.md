# Pass filter plugin for Embulk

```
$ embulk gem install embulk-plugin-input-random
$ embulk run random.yml
```

```
$ ./gradlew gem
$ embulk run -I lib example.yml
2015-06-23 11:24:15.729 +0900: Embulk v0.6.12
2015-06-23 11:24:18.674 +0900 [INFO] (transaction): Listing local files at directory '.' filtering filename by prefix 'sample.000.00'
2015-06-23 11:24:18.688 +0900 [INFO] (transaction): Loading files [sample.000.00.csv]
2015-06-23 11:24:18.828 +0900 [INFO] (transaction): {done:  0 / 1, running: 0}
2015-06-23 11:24:18.910 +0900 [WARN] (task-0000): Skipped line 2 (java.lang.NumberFormatException: For input string: "id"): id,name,score
2015-06-23 11:24:19.583 +0900 [INFO] (transaction): {done:  1 / 1, running: 0}
2015-06-23 11:24:19.612 +0900 [INFO] (main): Committed.
2015-06-23 11:24:19.612 +0900 [INFO] (main): Next config diff: {"in":{"last_path":"sample.000.00.csv"},"out":{}}
```

```
Committed - Loading file = 0.924 sec
```

Compare with Ruby version: https://github.com/sonots/embulk-filter-ruby-pass

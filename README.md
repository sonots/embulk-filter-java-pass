# Pass filter plugin for Embulk

```
$ ./gradlew gem
$ embulk run random.yml
$ embulk run -I lib example.yml
2015-06-23 00:39:50.535 +0900: Embulk v0.6.11
2015-06-23 00:39:52.671 +0900 [INFO] (transaction): Listing local files at directory '.' filtering filename by prefix 'sample.000.00'
2015-06-23 00:39:52.680 +0900 [INFO] (transaction): Loading files [sample.000.00.csv]
2015-06-23 00:39:52.818 +0900 [INFO] (transaction): {done:  0 / 1, running: 0}
2015-06-23 00:39:53.282 +0900 [INFO] (transaction): {done:  1 / 1, running: 0}
2015-06-23 00:39:53.310 +0900 [INFO] (main): Committed.
2015-06-23 00:39:53.311 +0900 [INFO] (main): Next config diff: {"in":{"last_path":"sample.000.00.csv"},"out":{}}
```

Compare with Ruby version: https://github.com/sonots/embulk-filter-ruby-pass

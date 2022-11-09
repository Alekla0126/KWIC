# KWIC solved with pipes and filters

## Alekla: Alejandro Lagunes

[![J|Java](https://skillicons.dev/icons?i=java)]()
[![Production](https://skillicons.dev/icons?i=idea)]()

The KWIC index system accepts an ordered set of lines, each line is an ordered set of words, and each word is an ordered set of characters. Any line may be "circularly shifted" by repeatedly removing the first word and appending it at the end of the line. The KWIC index system outputs a listing of all circular shifts of all lines in alphabetical order.

## Features

[![Production](https://courses.cs.washington.edu/courses/cse503/00sp/lecture%203%20(lifecycle%20and%20kwic)_files/image008.jpg)]()

An example is:

Green Sleeves
Time Was Lost

The corresponding KWIC index is:

                               Day after Tomorrow the
                               Fast and Furious
                               Furious Fast and
                               Man of Steel
                               Steel Man of
                               Tomorrow the Day After
                               Green Sleeves

## Tech:

- [Java] - Java was used for the implementation

## Installation

Java compiler 1.8+ [Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) v1.8+ to run.

Install the dependencies and devDependencies and start the server.

```sh
git clone git@github.com:Alekla0126/KWIC.git
cd path/to/KWIC/src/
```

## Build it and try it!

Want to contribute? Great!

```sh
git clone git@github.com:Alekla0126/KWIC.git
```
Run it with:

```sh
javac Main.java
```
```sh
java Main
```

Made and compiled with Jetbrains IntelliJ.

## License

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [Java]: <https://www.java.com/es/>

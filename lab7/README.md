# Program To Write

Here is the specification of the program you are to write.

1. The program should accept two parameters on the command line:

    1. a string representing the URL at which to start browsing
    2. a positive integer representing a maximum search depth (see below)

If the correct arguments are not supplied, the program should immediately stop and print out a usage message e.g.

    usage: java Crawler <URL> <depth>

(To learn more about processing command-line arguments in Java, you can read [this page](http://users.cms.caltech.edu/~donnie/cs11/java/java-main.html).)

2. The program should store the URL as a String along with its depth (which is 0 to start). You should create a special class to represent [URL, depth] pairs.

3. The program should connect to the given site within the URL on port 80 using a Socket (see below) and request the specified web page,

4. The program should parse the returned text, if any, line by line for any substrings which have the format:

    ```
    <a href="[any URL starting with http://]">
    ```

    Found URLs should be stored, along with a new depth value in a LinkedList of (URL, depth) pairs (see below for more about LinkedLists). The new depth value should be one more than the depth value of the URL corresponding to the page being parsed.

5. The program should then close the socket connection to the host.

6. The program should then repeat steps 3 to 6 on each new URL, as long as the depth corresponding to the URL is less than the maximum depth. Note that when a particular URL is retrieved and searched, the search depth goes up by 1. If a URL's depth has reached the maximum depth (or greater), do not retrieve or search that web page.

7. Finally, the program should print out all the URLs visited along with their search depths.

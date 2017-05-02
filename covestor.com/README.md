covestorCodeTest
================

Front End Engineering Test
================

We provide a JSON data source at: http://api.covestor.com/ajax-test

As you can see, it's a simple 2-d array, served as application/json

Your task is to build a web page which makes an AJAX request to this URL, parses the resulting data and builds a HTML table.

The table should look something like:

|   Animal  | Legs |
| --------- | ---- |
| trout     |   0  |
| chicked   |   2  |
| zebra     |   4  |
| spider    |   8  |

When the header cell "Animal" is clicked on, the table should be sorted alphabetically on the 1st column and when the header cell "Legs" is clicked on, the table should be sorted numerically on the 2nd column. Do not use any library (e.g. jquery.tablesorter.js or equivalent) to implement the table; please hand-craft it yourself.

The page should work in at least: IE8+, FF3+ & Chrome.

Notes:

1.We strongly encourage the use of JQuery (but if you prefer another library, or want to go freestyle, that's your call).

2.As you'll be pulling the data from our site, you'll have to solve the 'same origin policy' issue. To make this easy, we support JSONP requests; JQuery's support for them will work nicely. If you are using SCRIPT tags to pull the data, you can specify your callback like this: http://api.covestor.com/ajax-test?callback=myCallback If cross-domain AJAX and JSONP mean nothing to you, you are allowed to paste the response from our API directly to the top of your page as a JS string and pretend that you retrieved it dynamically. Points will be deducted if you use a JSON literal instead of a string.

3.For our convenience, please inline everything (i.e. CSS, JS) into a single HTML file. You can either host this file yourself and give us a URL, or email it to us.

Back End Engineering Test
================

We have an RSS feed of our blog available at: http://blog.covestor.com/feed (an Atom feed is also available at http://blog.covestor.com/feed/atom)

We would like to know what is the most common word in each of the postings. We are only interested in the words that occur in the body of the posting, i.e. inside the <content> tag.

We want to avoid common words, so please exclude anything in this list: http://www.textfixer.com/resources/common-english-words.txt

For bonus points, we'd also like to know the most common word across all of the postings.

Your code should run on a Java6 JVM (i.e. Java, Groovy - preferred if you know it, Clojure, etc). You can also do this in ColdFusion.

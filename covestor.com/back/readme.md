Covestor Back Code test
==============

Introduction
==============

As introduced in front end exercise, additionally to the original requirements, implemented in RSSWordCounter, a JSON API
is included to allow getting and showing generated information in the front side.

To the original exercise classes (including Spock tests), I have added a full Grails environment with a Controller
(also Spock tested) allowing generated data to be accessible as JSON to the front side.

IMPORTANT: I have used a server that is not very powerful and already crowded, access to data is pretty slow, please be
patient for the second table to load (a simple cache could easily solve this problem, but I detected it with not much
time left to introduce modifications).

Installation
--------------

- **Grails Installation**

    Download installer from: http://grails.org/doc/2.4.x/guide/gettingStarted.html
    or even better use: http://gvmtool.net/

- **To launch included test**

    grails test-app

- **To start webapp locally**

    grails run-app

- **War generation**

    grails war
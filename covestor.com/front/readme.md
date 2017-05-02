Covestor Front Code test
==============

Introduction
--------------

I have used the same tools I often choose for my real front end applications: gulp for building (depending on node.js
and bower) and coffeescript to code (gulp automatically compiles to javascript and links it with the application files).

Code is in app/src. Coffescript in app/src/coffee and Javascript in src/js/js

I understand the requirement for inline CSS and JS does not apply to this exercise, as is something probably included
to simplify. Anyway, there is a compliant version in www-inline.

Additionally to the required table, a second one is included to show back end exercise data through included JSON API.

Installation
--------------

- **node.js Installation**

    Download installer from: http://nodejs.org/

- **Global Bower Installation**

    sudo npm install -g bower

- **Global Gulp Installation**

    sudo npm install -g gulp

- **Updating Node and Bower**.

    npm update
    bower update

- **Building app**

    gulp (cleans and creates www dir with all front app files).
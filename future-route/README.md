futureRouteCodeTest
===================

Create a Web Application

*	Create a User entity with name, locale and a list of Reports as attributes.

*	The Report is also an entity with the report name as it attribute.

*	The report name must be in the format 'report_${report_number}' where report number is an incremental number starting at 1 and is relative to the number of reports that particular user has.

* Create a web page to display the user and list the reports that the user has. 

*	The report name should be presented in ROT13 if the user has an fr_FR locale.

*	There should be a way to generate a new report and add it to the list for each user. When clicked it should generate the report.

*	The number of active report generation requests should be displayed.

*	The report generation should be simulated by a 3 second wait (not by a setTimeout on the client side) before displaying the new report in the list for the correct user, in the correct format.

*	Refreshing the page should show all reports that have previously been generated.

*	(Optional) When the application starts there should be 2 users, one with a en_GB locale and one with a fr_FR locale

Use whatever third party plugins or frameworks you feel comfortable with, but also remember the part of the purpose of this task is to see what your code and feature design looks like. This task is best treated as though a complete piece of work you would commit to our codebase.

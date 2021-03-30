# clubsystem

<h1>Instructions for setup</h3>

Make sure you have mysql, java 11, and some IDE (intelliJ for me) installed.

Clone the repo. (Run git clone https://github.com/sarthyparty/clubsystem/ in terminal).

Next, open up the project in an IDE (preferably intelliJ).

Open up terminal and start mysql. (mysql.server start)

Log in to root. (mysql -u root -p). The default password is blank, so just hit enter when it prompts you (if you haven't set a password).

Once you have entered your password correctly (blank if you haven't set one), you should open up to the mysql command line. We'll first create the database. If you did not create a password, press enter and the mysql command line should still open.

Run (create database club_system;)

Then we'll create a user and grant privileges to it. Run (create user 'springBootApp'@'%' identified by 'futurist';) Run (grant all on club_system.* to 'springBootApp'@'%';) Finally, run (flush privileges;)

Now, you need to download some library modules in the following steps:  
In IntelliJ, go to File>Project Structure.  
Under Project Settings, click Libraries.  
Click the + symbol at the upper left>select From Maven...>paste this: mysql:mysql-connector-java:8.0.23 and check the "Download To" box>Press OK  
Select all 3 options (clubsystem, clubsystem.main, clubsystem.test)>Press Apply>Press OK  

Now if you have this opened in intelliJ, you should be able to just hit the play button in the top right to run it.  


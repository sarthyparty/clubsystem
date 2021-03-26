# clubsystem

<h1>Instructions for setup</h3>

Make sure you have mysql, java 11, and some IDE (intelliJ for me) installed.

Clone the repo. (Run git clone https://github.com/sarthyparty/clubsystem/ in terminal).

Next, open up the project in an IDE (preferably intelliJ).

Open up terminal and start mysql. (mysql.server start)

Log in to root. (mysql -u root -p)

Once you have entered your password correctly (or created a password), you should open up to the mysql command line. We'll first create the database.

Run "create database club_system;"

Then we'll create a user and grant privileges to it. Run "create user 'springBootApp'@'%' identified by 'futurist';" Run "grant all on club_system.* to 'springBootApp'@'%'; Finally, run "flush privileges.

Now if you have this opened in intelliJ, you should be able to just hit the play button in the top right to run it.

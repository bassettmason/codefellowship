

# Code Fellowship
## 

## Challenge
Sign up users and store their info and hashed passwords in database
### Feature Tasks
-The site should have a splash page at the root route (/) that contains basic information about the site
-link to the “sign up” page.
-An ApplicationUser should have a username, password (will be hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and picture.
-The site should allow users to create an ApplicationUser on the “sign up” page. (For now, there is no such thing as login.)
-Your Controller should have an @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder; and use that to run bCryptPasswordEncoder.encode(password) before saving the password into the new user.
-The site should have a page which allows viewing the data about a single ApplicationUser, at a route like /users/{id}.(not sure purpose or how to do this)
This should include a default profile picture, which is the same for every user, and their basic information.
## How to use it
Sign up link and then fill out form and it stores user info in data base.


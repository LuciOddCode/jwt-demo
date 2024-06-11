JWTUtil: Your API’s Bouncer
How to Use This Beast:

Gettin' Set Up:

Clone It, Baby: Grab this project, clone it, and get your dev environment rolling (you know the drill: IDE, Maven, the usual suspects).

DB Shenanigans:

You need a database for your user data (like usernames, passwords, the whole shebang). Set that up and tweak your Spring Boot application properties to match your setup.
Check out our DTO and Entity classes for user data. Adjust them to fit your data structure. Need help? Well, good luck finding me!
Customizing Your JWT (Optional):

Our JWTs come with "roles" included. Want to add more? Dive into generateToken and sprinkle in some extra claims with your user's special details.
Integration Time!

User Authentication:

Implement your user login logic (think username/password checks).
On successful login, use JWTUtil.generateToken(userDetails) to mint a JWT token. (userDetails is a Spring Security UserDetails object).
Token Deployment:

Stick that token in the Authorization header of future API requests. Format: "Bearer <token>".
Spring Security Hookup:

Set up your Spring Security filters to fish out the JWT token from the Authorization header and validate it using JWTUtil.validateToken(token, userDetails). This ensures only the cool kids (authorized users) get in.
The Nitty Gritty:

getUserIdByToken(HttpHeaders headers, String secret): Grabs the user ID from a JWT token in the Authorization header (using static secret validation).
generateToken(UserDetails userDetails): Crafts a JWT token with user info.
validateToken(String token, UserDetails userDetails): Validates a JWT token based on user details and expiration.
extractUsername(String token): Extracts the username from a JWT token.
extractRoles(String token): Pulls out the user roles from a JWT token (assuming a "roles" claim is present).
Remember:

SECRET_KEY: This key signs and verifies tokens. Keep it safe in your application properties (guard it like the last piece of chocolate).
Token Expiration & Refresh: Think about how to handle JWT expiration and refresh for longer sessions.
This is just the beginning. There’s a whole galaxy of JWT customization and best practices out there. Go forth and make this JWTUtil your own masterpiece!

UserDetailsService: The Undercover Agent
Here's the How-Down:

Spring Security Needs a Hand:

User Details: Spring Security needs intel about your users to grant them access. This service acts like a secret agent, fetching that info whenever Spring Security whispers a username.
Let’s Break the Code:

Autowiring the User Repo:

The @Autowired magic injects UserRepo into this service (think of it as your hidden treasure trove).
loadUserByUsername Method:

This is the heart of the action. It takes a username and dives into the UserRepo to find a match.
No match? Boom! It throws a "UsernameNotFoundException" – like, who even are you?
If it finds the user, it builds a UserDetails object, holding all the user's secrets: username, password, and roles (like a secret dossier).
Spring Security Gets the Goods:

Finally, this service hands over the UserDetails object to Spring Security. Now, Spring Security can check the credentials and decide if the user gets to waltz in or not.
Remember:

This is just a basic setup. Depending on your user data and security needs, you might need to add some extra flair. But with this custom service, you’ve got a solid foundation for user authentication. Now go forth and show those login attempts who's boss!
There you go! A playful yet functional guide to handling JWTs and UserDetailsService in your Spring Boot app. Happy coding! 🚀

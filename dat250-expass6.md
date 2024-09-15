Report of Errors Encountered and Solutions Implemented**

Throughout the development of my project, I encountered several issues in both the front-end and back-end setup. Below is a detailed summary of the errors I faced, how they were resolved, and what remains unresolved.

I have managed to solve the first four steps but not the fifth one.

---

### **Errors Encountered and Solved**

1. **ESLint and TypeScript Errors**

    - At the beginning, I encountered an ESLint error in Intellij, as well as TypeScript errors like `'React' is declared but its value is never read`. This happened due to changes in how React and TypeScript handle imports. The issue was solved by removing unnecessary `React` imports in my `.tsx` files.
2. **Vote Handling Logic**

    - Initially, I faced issues with the vote handling logic in my front-end components, where upvotes and downvotes were not updating correctly. This was due to how state was being updated. The solution involved making sure I correctly copied the `votes` state and properly managed the `handleVote` function.
3. **CORS (Cross-Origin Resource Sharing) Issues**

    - When making requests from the front-end to the back-end API, I ran into CORS errors because the front-end was being served on `localhost:5173` and the back-end on `localhost:8080`. This was resolved by adding the `@CrossOrigin(origins = "http://localhost:5173")` annotation in my Spring Boot controllers to allow requests from the front-end.
4. **Connection Refused and 404 Errors**

    - While interacting with the API from the front-end, I encountered errors like `ERR_CONNECTION_REFUSED` and `404 Not Found`. These occurred because the front-end was making requests to incorrect URLs or the API paths were not properly mapped. After correcting the relative `fetch` URLs and ensuring the correct API paths were set up in the Spring Boot controller, the issue was resolved.
5. **Building the Front-End (Vite)**

    - After running `npm run build` to build my front-end project, I faced some errors related to TypeScript and React. The error occurred because React was imported but not used, leading to warnings. Removing the unused `React` imports fixed this issue.

### Unsolved issues:

My build.gradle.kts file has had errors since the beginning but I do not know why. The program still runs so I have 
simply ignored it. 

I have manage to do everything up until this step:

*command, which will produce a few static assets (html, css, js) in the `/dist` directory. Copy those files into your Spring Boot application at `/src/main/resources/static` and see what appens :) (Do not forget to replace the absolute `http://localhost` URIs in you `fetch()` calls with relative URLs before going into production 😉)*


For some reason I can't get it to run on localhost:8080 with the new front end and not the old demo one. 

Front end link: https://github.com/FarAwayPizza/frontEnd-gradle-build-action/tree/master


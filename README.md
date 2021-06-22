# BookStore

### Title: Book Store

### Background
Build a website to sell IT books like TIKI.VN

### Program Specifications
In this assignment, you are requested to develop a simple Ecommerce website to sell IT books. 
Student must use Servlet as Controller and follow MVC2 model.

### Features:
### *_This system contains the following functions:_*
**Function 1: Login- 50 Points**
- In order to shopping, an authentication is required.
- If the user has not authenticated, the system redirects to the login page.
- The actor enters userID and password.
  - The function checks if the userID with the password is in the available user list, then grant the 
access permission.
  - Otherwise, a message would appear no notify that user is not found.
- Login function is required to shopping.

**Function 2: Search- 50 Points**
- List all books available in the system with book’s status is active and quantity greater than 0.
- Each book has a title, image, description, price, author, category, …
- User can find the book based on name or range of money or category.
- All users can use this function (login is not required)

**Function 3: Delete- 50 points**
- Only Admin role has permission to do this function.
- This function is used to remove the selected book.
- The confirm message will show before delete action.
- System will update list book after delete.
- Remember that delete action is update the status of the book to Inactive.

**Function 4: Update- 50 points**
- Only Admin role has permission to do this function (login is required)
- Update information of the selected book with tittle, price, author, category, import date, quantity,... fields

**Function 5: Insert- 50 points**
- Only Admin role has permission to create a new book.
- This function is used to create new book into system
- Date will be imported is current date.
- The default status of new book is active.

**Function 6: shopping- 100 points**
- All users can use this function except Admin role (login is required)
- This function allows user add the selected book to shopping cart. The default quantity is 1.
- Each user can buy any available book in the list (not limit the amount book want to buy)
- User can view the selected book in the cart. 
  - For each book, the information is shown as book name, amount, price, total. 
  - The screen must show the total amount of money of this cart.
- User can remove the book from the cart. The confirm message will show before delete action.
- User can update amount of each book in cart.
- When user clicks the Confirm button to store the booking to database (must store the buy date time). 
- The warning message will show if the select book is out of stock.

**Function 7: Discount code- 50 points(extra)**
- When user enter the discount code, each discount code is applied with one user and using one time.

**Function 8: Shopping history- 50 points(extra)**
- User can take over the shopping history.
- This function will be support search older shopping orders following search by name or shopping date

**Function 9: Integrate online payment- 100 points (extra)**
- User can pay online (using paypal, momo, vnpay, etc)

**Function 10: Create discount code- 50 points( extra)**
- Only admin can user this function.
- This function allows to create discount code which has some basic information such as ID, discount 
percent, date.

** The above specifications are only basic information; you must build the application according to real requirements.

** You have to build your own database. 

** The lecturer will explain the requirement only once on the first slot of the assignment.

### LAB 321Assignment SPRING 2021
&copy; FPT University

#### Connect me via:

[My facebook](https://fb.com/lehuuhieu.1011)  
[My email](mailto:lehuuhieuak@gmail.com)


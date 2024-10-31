# Dry Cleaners JavaFX Application

## Overview
This JavaFX application is designed for cashiers at a dry cleaning business. It allows cashiers to log in, clock in and out, manage customer information, and handle orders.

## Recommended IDE
**IntelliJ IDEA is highly recommended** for running this application. It may not build correctly in other IDEs.

## Getting Started

### Step 1: Run the Application
- Open the project in IntelliJ.
- Execute the program from `HelloApplication.java`.

### Step 2: Login
- A login screen will appear.
- Enter your first and last name in the respective fields.
- Choose a 4-digit key (note: `7777` and `8888` are reserved for testing).
- Click **Submit**.

### Step 3: Home Page
- Upon successful login, a **Home** button will appear. Click it to navigate to the home page.

## Application Workflow

### Main Interface
- Side tabs (from top to bottom):
  - Home
  - Find Customer
  - Clothes Tag In
  - Order Pick Up
  - Clock In/Out
  - Logout

### Cashier Workflow
1. **Clock In**
   - Enter your key and date in the appropriate fields.
  
2. **Handling Customers**
   - When a customer arrives, determine if they are dropping off or picking up items.
   - For new customers, navigate to the **Find Customer** tab.

3. **Adding New Customers**
   - In the **PINK NEW CUSTOMER** section, input the customer's first name, last name, and phone number (use a consistent format, e.g., `xxx-xxx-xxxx`).
   - Click **Add Cust** to save the new customer info.

4. **Clothes Tag In**
   - Navigate to the **Clothes Tag In** tab.
   - Enter the customer's phone number and details about their clothes.
   - Submit orders for each type of clothing (e.g., group shirts by color).

5. **Review Orders**
   - After tagging in clothes, go back to **Find Customer**.
   - Use the **Open Order** button to view the submitted orders.

6. **Order Pick Up**
   - Go to the **Order Pick Up** tab.
   - Input the customer's phone number and the order ID.
   - Confirm the order details and submit.

### Clock Out and Logout
- Don’t forget to clock out to ensure proper payment.
- Logout from the application when finished.

## Notes
- The application interface may seem unintuitive initially, but it effectively handles the necessary tasks.
- Future updates may include enhancements for a better user experience.


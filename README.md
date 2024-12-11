# Institute-Management-System-using-jdbc-Servlet--jsp
Here's a concise and keyword-optimized rewrite for your GitHub project description:  

---

# Institute Management System  
A Java-based web application for managing students and users, showcasing the use of **JSP**, Jdbc,**Servlets**, and **Java Beans** for dynamic web development.  

## Features  
- **Student Management**: Add, update, view, and delete student details (name, age, email, course, address).  
- **User Authentication**: Registration and login system for secure access.  
- **Modular Design**: Clean separation of concerns with Java Beans.  
- **Web Interface**: User-friendly JSP pages for seamless interaction.  

## Technologies  
- **Java** (JDK 8+)  
- **JSP** (JavaServer Pages)  
- **Servlets**  
- **Apache Tomcat 9**  
- **HTML/CSS** (Basic UI)
- MySql (8.0.0) and above

## Project Structure  
### **JSP Pages**  
1. **`login1.jsp`**: Login page with registration redirection.  
2. **`reg1.jsp`**: User registration form.  
3. **`home.jsp`**: Dashboard after login.  
4. **`studentform.jsp`**: Form to add new student details.  
5. **`display.jsp`**: Displays all student records in a table.  
6. **`update.jsp`**: Update student data by mobile number.  
7. **`delete.jsp`**: Delete a student record by mobile number.  

### **Servlets**  
- **`MyServlet.java`**: Handles all business logic and routes URLs to appropriate methods.  

### **Bean Classes**  
- **`StudentBean.java`**: Represents student data (ID, name, age, mobile, address, email, course).  
- **`User1.java`**: Represents user data (name, email, password).  

## Setup Instructions  
### **Prerequisites**  
- Install **JDK 8+**.  
- Install **Apache Tomcat**.  
- Use a Java IDE (e.g., Eclipse, IntelliJ IDEA).  

### **Steps to Run**  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/your-username/institute-management-system.git  
   cd institute-management-system  
   ```  
2. Configure and deploy on Tomcat in your IDE.  
3. Access the app at:  
   ```  
   http://localhost:8080/institute-management-system/  
   ```  

### **Database Setup**  
- Use **MySQL** or any RDBMS.  
- Create tables for `students` and `users` using fields from the Bean classes.  
- Update database credentials in the Servlet/DAO classes.  

## Usage  
1. **User Registration**:  
   Navigate to `register.jsp`, fill in details, and create an account.  
2. **Login**:  
   Log in via `login1.jsp` to access the dashboard.  
3. **Manage Students**:  
   - Add via `studentform.jsp`.  
   - View via `display.jsp`.  
   - Update via `update.jsp`.  
   - Delete via `delete.jsp`.  

## Contributing  
1. Fork the repo.  
2. Create a branch:  
   ```bash  
   git checkout -b feature-name  
   ```  
3. Commit changes:  
   ```bash  
   git commit -m "Add feature"  
   ```  
4. Push to your branch:  
   ```bash  
   git push origin feature-name  
   ```  
5. Open a pull request.  



--- 

